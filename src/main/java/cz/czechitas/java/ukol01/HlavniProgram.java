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

//        // 2.PART
//        // Back to default position
//        goToDefaultPosition(90, 140, Direction.LEFT, 90, 50, Direction.LEFT);
//        // Octagon
//        drawOctagon();
//        // Back to default position
//        goToDefaultPosition(90, 90, Direction.RIGHT, 90, 30, Direction.RIGHT);
//        // Circle
//        drawCurve(20, 12, 18, Direction.LEFT);
//        //Back to default position
//        goToDefaultPosition(90, 180, Direction.LEFT, 90, 12, Direction.LEFT);
//        // Sun
//        drawCurve(20, 12, 18, Direction.LEFT);
//        drawSunRays(20, 20, 6, 18);

        // 3.PART
//        drawPicture();
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

    public void moveTo(double x, double y) {
        zofka.penUp();
        zofka.setLocation(x, y);
        zofka.penDown();
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

    public void drawCurve(int steps, double stepLength, double circleAngle, Direction circleDirection) {
        for (int i = 0; i < steps; i++) {
            turnAndMove(circleAngle, stepLength, circleDirection);
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
    public void drawPicture() {
        // Sun
        moveTo(400, 50);
        drawCurve(26, 6, 14, Direction.LEFT);// Sun
        drawSunRays(26, 10, 3, 14);

        // Houses
        moveTo(300, 150);
        zofka.turnLeft(172);
        for (int i = 0; i < 5; i++) {
            drawHouse(50, 70);

            if (i < 4) {
                moveTo(zofka.getX() + 130, zofka.getY());
                zofka.turnLeft(90);
            }
        }

        // MIDDLE ROW
        moveTo(zofka.getX() + 50, 300);
        zofka.turnLeft(90);

        // Right-side house
        drawHouse(50, 70);

        // Piggy
        moveTo(zofka.getX() - 150, 300);
        zofka.turnRight(90);
        drawPiggy(70, 50);

        // Left-side house
        moveTo(300, 300);
        drawHouse(50, 70);

        // 4.PART
        drawName();
    }

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

    // 4.PART
    public void drawName() {
        // default position
        moveTo(300, 500);
        zofka.turnRight(90);
        drawS();
        // diacritics
        moveTo(zofka.getX() - 20, zofka.getY() - 20);
        drawLegs(190);
        // default position
        moveTo(zofka.getX() + 30, 500);
        zofka.turnRight(150);
        drawA();
        // diacritics
        moveTo(zofka.getX() + 15, zofka.getY() - 40);
        turnAndMove(110, 30, Direction.RIGHT);
        // default position
        moveTo(zofka.getX() + 30, 500);
        zofka.turnRight(-20);
        drawR();
        // default position
        moveTo(zofka.getX() + 20, 500);
        zofka.turnLeft(140);
        drawK();
        // default position
        moveTo(zofka.getX() + 10, 500);
        zofka.turnLeft(145);
        drawA();
        // default position
        moveTo(zofka.getX() + 60, 500);
        zofka.turnRight(90);
    }

    public void drawS() {
        turnAndMove(110, 15, Direction.RIGHT);
        for (int i = 0; i < 11; i++) {
            turnAndMove(20, 7, Direction.LEFT);
        }
        turnAndMove(50, 5, Direction.RIGHT);
        for (int i = 0; i < 11; i++) {
            turnAndMove(20, 7, Direction.RIGHT);
        }
    }

    public void drawA() {
        turnAndMove(20, 80, Direction.RIGHT);
        turnAndMove(140, 80, Direction.RIGHT);
        turnAndMove(180, 40, Direction.RIGHT);
        turnAndMove(70, 25, Direction.LEFT);
    }

    public void drawR() {
        zofka.move(60);
        drawCurve(20, 7, 16, Direction.RIGHT);
        turnAndMove(180, 60, Direction.RIGHT);
    }

    public void drawK() {
        zofka.move(80);
        turnAndMove(180, 40, Direction.RIGHT);
        turnAndMove(145, 48, Direction.LEFT);
        zofka.penUp();
        turnAndMove(180, 48, Direction.RIGHT);
        zofka.penDown();
        turnAndMove(70, 48, Direction.LEFT);
    }
}



