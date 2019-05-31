
/**
 * Classic Game Snake
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameSnake {
	final String TITLE_OF_PROGRAM = "Classic Game Snake";
	final String GAME_OVER_MSG = "Game over";

	final int POINT_RADIUS = 20;
	final int FIELD_WIDTH = 30;
	final int FIELD_HEIGHT = 20;
	final int FIELD_DX = 6;
	final int FIELD_DY = 25;

	final int START_LOCATION = 200;
	final int START_SNAKE_SIZE = 10;
	final int START_SNAKE_X = 10;
	final int START_SNAKE_Y = 10;

	// задержка для анимации
	final int SHOW_DELAY = 150;// in ms

	// коды клавиш
	final int LEFT = 37;
	final int RIGHT = 39;
	final int UP = 38;
	final int DOWN = 40;

	// стартовое направление
	final int START_DIRECTION = RIGHT;

	final Color DEFAULT_COLOR = Color.BLACK;
	final Color FOOD_COLOR = Color.green;
	final Color POISON_COLOR = Color.red;

	Snake snake;
	Food food;

	JFrame frame;
	Canvas canvasPanel;
	Random random = new Random();
	boolean gameOver = false;

	Poison poison = new Poison();
	Image apple, amanita; // images for food and poison

	public static void main(String[] args) {
		new GameSnake().go();
	}

	void go() {
		frame = new JFrame(TITLE_OF_PROGRAM + ":" + START_SNAKE_SIZE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FIELD_WIDTH * POINT_RADIUS + FIELD_DX, FIELD_HEIGHT * POINT_RADIUS + FIELD_DY);

		// стартовое положение окна
		frame.setLocation(START_LOCATION, START_LOCATION);
		// запретить изменение окна
		frame.setResizable(false);

		canvasPanel = new Canvas();
		canvasPanel.setBackground(Color.white);

		frame.getContentPane().add(BorderLayout.CENTER, canvasPanel);

		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.print(e.getKeyCode());
				snake.setDirection(e.getKeyCode());
			}
		});

		try {
			apple = ImageIO.read(new File("img/apple.png"));
			amanita = ImageIO.read(new File("img/amanita.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		frame.setVisible(true);

		snake = new Snake(START_SNAKE_X, START_SNAKE_Y, START_SNAKE_SIZE, START_DIRECTION);
		food = new Food();

		while (!gameOver) {
			snake.move();

			if (food.isEaten()) {
				food.next();
				poison.add();
			}
			canvasPanel.repaint();

			try {
				Thread.sleep(SHOW_DELAY);
			} catch (InterruptedException e) {
				gameOver = true;
			}
		}
	}

	public class Canvas extends JPanel {
		private static final long serialVersionUID = 1L;

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			snake.paint(g);
			food.paint(g);
			poison.paint(g);
			if (gameOver) {
				g.setColor(Color.RED);
				g.setFont(new Font("Arial", Font.BOLD, 40));
				java.awt.FontMetrics fm = g.getFontMetrics();
				g.drawString(GAME_OVER_MSG, (FIELD_WIDTH * POINT_RADIUS + FIELD_DX - fm.stringWidth(GAME_OVER_MSG)) / 2,
						(FIELD_HEIGHT * POINT_RADIUS + FIELD_DX) / 2);
			}
		}
	}

	class Snake {
		ArrayList<Point> snake = new ArrayList<Point>();
		int direction;

		public Snake(int x, int y, int length, int direction) {
			for (int i = 0; i < length; i++) {
				Point point = new Point(x - i, y);
				snake.add(point);
			}
			this.direction = direction;
		}

		void paint(Graphics g) {
			for (Point point : snake) {
				point.paint(g);
			}
		}

		boolean isFood(Point food) {
			if (food == null)
				return false;

			return ((snake.get(0).getX() == food.getX()) && (snake.get(0).getY() == food.getY()));
		}

		void move() {
			int x = snake.get(0).getX();
			int y = snake.get(0).getY();

			System.out.println("x : " + x + ", FIELD_WIDTH : " + FIELD_WIDTH);
			// расчитать новые координаты для головы
			if (direction == LEFT) {
				x--;
			} else if (direction == RIGHT) {
				x++;
			} else if (direction == UP) {
				y--;
			} else if (direction == DOWN) {
				y++;
			}

			// столкновения со сторонами
			if (x > FIELD_WIDTH - 1) {
				x = 0;
			} else if (x < 0) {
				x = FIELD_WIDTH - 1;
			} else if (y > FIELD_HEIGHT - 1) {
				y = 0;
			} else if (y < 0) {
				y = FIELD_HEIGHT - 1;
			}

			gameOver = isInsideSnake(x, y) || poison.isPoison(x, y); // check
																		// game
																		// over
			
			snake.add(0, new Point(x, y));

			// добавить новую координату для головы
			if (isFood(food)) {
				food.eat();
				frame.setTitle(TITLE_OF_PROGRAM + " : " + snake.size());
			} else {
				// значения из цифровых клавиш
				snake.remove(snake.size() - 1);
			}
		}

		boolean isInsideSnake(int x, int y) {

			for (Point point : snake) {
				if (point.getX() == x && point.getY() == y) {
					return true;
				}
			}

			return false;
		}

		void setDirection(int direction) {
			if (direction >= LEFT && direction <= DOWN) {
				if (Math.abs(this.direction - direction) != 2) {
					this.direction = direction;
				}
			}
		}

	}

	class Point {
		int x, y;
		Color color = DEFAULT_COLOR;

		public Point() {

		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public Point(int x, int y) {
			setXY(x, y);
		}

		void paint(Graphics g) {
			g.drawImage(apple, x * POINT_RADIUS, y * POINT_RADIUS, null);
		}

		void setXY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	class Food extends Point {
		public Food() {
			super(-1, -1);
			this.color = FOOD_COLOR;
		}

		public void next() {
			int x, y;

			// РµРґР° РјРѕР¶РµС‚ РЅР°С…РѕРґРёС‚СЊСЃСЏ РІРЅСѓС‚Рё Р·РјРµРё
			do {
				x = random.nextInt(FIELD_WIDTH);
				y = random.nextInt(FIELD_HEIGHT);
			} while (snake.isInsideSnake(x, y) || poison.isPoison(x, y));

			setXY(x, y);
		}

		public boolean isEaten() {
			if (this.getX() == -1 && this.getY() == -1)
				return true;

			return false;
		}

		public void eat() {
			setXY(-1, -1);
		}

		boolean isFood(int x, int y) {
			return (this.x == x) && (this.y == y);
		}

	}

	class Poison {
		private ArrayList<Point> poison = new ArrayList<Point>();

		boolean isPoison(int x, int y) {
			for (Point point : poison)
				if ((point.getX() == x) && (point.getY() == y))
					return true;
			return false;
		}

		void add() {
			int x, y;
			do {
				x = random.nextInt(FIELD_WIDTH);
				y = random.nextInt(FIELD_HEIGHT);
			} while (isPoison(x, y) || snake.isInsideSnake(x, y) || food.isFood(x, y));
			poison.add(new Point(x, y)); // , POISON_COLOR));
		}

		void paint(Graphics g) {
			for (Point point : poison)
				g.drawImage(amanita, point.getX() * POINT_RADIUS, point.getY() * POINT_RADIUS, null);
		}
	}
}
