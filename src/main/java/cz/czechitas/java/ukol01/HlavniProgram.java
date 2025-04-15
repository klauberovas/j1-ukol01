package cz.czechitas.java.ukol01;

import cz.czechitas.java.ukol01.engine.Turtle;

import java.awt.*;

public class HlavniProgram {
    private Turtle zofka;

    public enum Direction {
        LEFT, RIGHT
    }

    public static void main(String[] args) {
        new HlavniProgram().start();
    }

    public void start() {
        zofka = new Turtle();
        // Settings for turtle
        zofka.setPenColor(Color.black);
        zofka.setPenWidth(4);

        //TODO implementace domácího úkolu

//        // 1.PART
//        drawPiggy(100, 50);
//
//        // 2.PART
//        // Back to default position
//        goToDefaultPosition(90, 140, Direction.LEFT, 90, 50, Direction.LEFT);
//        // Octagon
//        drawOctagon();
//        // Back to default position
//        goToDefaultPosition(90, 90, Direction.RIGHT, 90, 30, Direction.RIGHT);
//        // Circle
//        drawCircle(20, 12, 18);
//        //Back to default position
//        goToDefaultPosition(90, 180, Direction.LEFT, 90, 12, Direction.LEFT);
//        // Sun
//        drawCircle(20, 12, 18);
//        drawSunRays(20, 20, 6, 18);

        // 3.PART
        // UPPER ROW
        goToDefaultPosition(90, 200, Direction.LEFT, 90, 300, Direction.RIGHT);
        drawCircle(26, 6, 14);// Sun
        drawSunRays(26, 10, 3, 14);

        // Houses
        goToDefaultPosition(82, 40, Direction.LEFT, 90, 150, Direction.LEFT);
        for (int i = 0; i < 5; i++) {
            drawHouse(100, 120);
            if (i < 4) {
                goToDefaultPosition(180, 250, Direction.LEFT, 90, 0, Direction.RIGHT);
            }
        }

        // MIDDLE ROW
        goToDefaultPosition(90, 220, Direction.LEFT, 90, 100, Direction.LEFT);
        zofka.turnRight(90);

        // Right-side house
        drawHouse(100, 120);

        // Piggy
        goToDefaultPosition(0, 300, Direction.RIGHT, 90, 0, Direction.RIGHT);
        drawPiggy(100, 50);

        // Left-side house
        goToDefaultPosition(180, 50, Direction.RIGHT, 90, 200, Direction.LEFT);
        zofka.turnLeft(90);
        drawHouse(100, 120);
    }

    public void goToDefaultPosition(double firstAngle, double firstDistance, Direction firstDirection, double secondAngle, double secondDistance, Direction secondDirection) {
        zofka.penUp();
        turnAndMove(firstAngle, firstDistance, firstDirection);
        turnAndMove(secondAngle, secondDistance, secondDirection);
        zofka.penDown();
    }

    public void turnAndMove(double angle, double distance, Direction turn) {
        if (turn == Direction.RIGHT) {
            zofka.turnRight(angle);
        } else {
            zofka.turnLeft(angle);
        }
        zofka.move(distance);
    }

    // PIG
    public void drawPiggy(double bodyLength, double bodyHeight) {
        // top line of the body
        turnAndMove(90, bodyLength, Direction.RIGHT);
        // right side of the body
        turnAndMove(90, bodyHeight, Direction.RIGHT);
        // pig tail of the body
        drawPigTail(bodyHeight);
        // back legs
        drawLegs(30);
        // bottom line of the body
        turnAndMove(120, bodyLength, Direction.LEFT);
        // front legs
        drawLegs(120);
        // head
        drawHead(90, Direction.LEFT, 120, Direction.RIGHT, 50);
        // left side of the body
        turnAndMove(120, bodyHeight, Direction.RIGHT);
    }

    public void drawPigTail(double sideLength) {
        zofka.penUp();
        zofka.move(-sideLength / 2);
        zofka.turnLeft(90);
        zofka.penDown();
        zofka.move(20);
        // draw spiral tail
        for (int i = 0; i < 10; i++) {
            zofka.turnLeft(20);
            zofka.move(2);
        }
        // return back to original position
        zofka.penUp();
        for (int i = 0; i < 10; i++) {
            zofka.move(-2);
            zofka.turnRight(20);
        }
        zofka.move(-20);
        zofka.turnRight(90);
        zofka.move(sideLength / 2);
        zofka.penDown();
    }

    public void drawLegs(double angle) {
        zofka.turnLeft(angle);
        zofka.move(40);
        zofka.penUp();
        zofka.turnRight(120);
        zofka.move(40);
        zofka.turnRight(120);
        zofka.penDown();
        zofka.move(40);
    }

    public void drawHead(double firstAngle, Direction firstTurn, double secondAngle, Direction secondTurn, double sideLength) {
        turnAndMove(firstAngle, sideLength, firstTurn);
        turnAndMove(secondAngle, sideLength, secondTurn);
    }

    // 2.PART
    public void drawOctagon() {
        for (int i = 0; i < 8; i++) {
            zofka.turnRight(45);
            zofka.move(30);
        }
    }

    public void drawCircle(int steps, double stepLength, double circleAngle) {
        for (int i = 0; i < steps; i++) {
            zofka.turnLeft(circleAngle);
            zofka.move(stepLength);
        }
    }

    public void drawSunRays(int steps, double rayLength, double circleStepLength, double circleAngle) {
        boolean canDraw = true;
        for (int i = 0; i < steps; i++) {
            zofka.turnLeft(circleAngle);
            zofka.move(circleStepLength);
            if (canDraw) {
                zofka.penDown();
                zofka.turnRight(90);
                zofka.move(rayLength);
                zofka.penUp();
                zofka.turnLeft(180);
                zofka.move(rayLength);
                zofka.turnRight(90);
            }
            zofka.move(circleStepLength);
            canDraw = !canDraw;
        }
    }

    // 3.PART
    public void drawHouse(double houseLength, double houseHeight) {
        drawBody(houseLength, houseHeight);
        drawRoof(houseLength);
    }

    public void drawBody(double houseLength, double houseHeight) {
        zofka.move(houseHeight);
        turnAndMove(90, houseLength, Direction.RIGHT);
        turnAndMove(90, houseHeight, Direction.RIGHT);
    }

    public void drawRoof(double houseLength) {
        drawHead(30, Direction.RIGHT, 120, Direction.RIGHT, houseLength);
        turnAndMove(120, houseLength, Direction.RIGHT);
    }
}

