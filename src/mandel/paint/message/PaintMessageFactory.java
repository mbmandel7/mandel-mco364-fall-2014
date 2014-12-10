package mandel.paint.message;

import java.util.Scanner;

public class PaintMessageFactory {

	public PaintMessage getMessage(String message) {

		@SuppressWarnings("resource")
		Scanner parse = new Scanner(message);

		String messageType = parse.next();

		switch (messageType) {

		case "LINE":
			int x1 = parse.nextInt();
			int y1 = parse.nextInt();
			int x2 = parse.nextInt();
			int y2 = parse.nextInt();
			int lineColor = parse.nextInt();
			int stroke = parse.nextInt();
			return new LineMessage(x1, y1, x2, y2, lineColor, stroke);
		case "SHAPE":
			String type = parse.next();
			int shapeX = parse.nextInt();
			int shapeY = parse.nextInt();
			int width = parse.nextInt();
			int height = parse.nextInt();
			int shapeColor = parse.nextInt();
			int shapeStroke = parse.nextInt();
			boolean fill = parse.nextBoolean();
			return new ShapeMessage(type, shapeX, shapeY, width, height, shapeColor, shapeStroke, fill);
		case "CLEAR":
			return new ClearMessage();
		case "BUCKET_FILL":
			int x = parse.nextInt();
			int y = parse.nextInt();
			int color = parse.nextInt();
			return new BucketFillMessage(x, y, color);
		}
		return null;

	}

}
