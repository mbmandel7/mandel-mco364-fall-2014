package mandel.paint.message;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Stack;

import mandel.paint.Canvas;

public class BucketFillMessage implements PaintMessage {

	private int x;
	private int y;
	private int color;
	private int clickedColor;
	private Canvas canvas;
	private Stack<Point> stack;

	public BucketFillMessage(int x, int y, int color, Canvas c) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
		this.canvas = c;
		clickedColor = canvas.getImage().getRGB(x, y);

	}

	@Override
	public void apply(Graphics2D g) {
		// TODO Auto-generated method stub
		stack = new Stack<Point>();
		stack.push(new Point(x, y));
		Point p;
		while (!stack.isEmpty()) {
			p = stack.pop();
			test(new Point(p.x, p.y - 1));
			test(new Point(p.x - 1, p.y));
			test(new Point(p.x, p.y + 1));
			test(new Point(p.x + 1, p.y));
		}
	}

	public String toString() {
		return "BUCKET_FILL " + x + " " + y + " " + color + "\n";
	}

	public void test(Point temp) {
		if (temp.x < 800 && temp.y < 600 && temp.x > -1 && temp.y > -1) {
			int colorTest = this.canvas.getImage().getRGB(temp.x, temp.y);
			if (clickedColor == colorTest) {
				canvas.getImage().setRGB(temp.x, temp.y, color);
				stack.push(temp);
			}
		}
	}

}
