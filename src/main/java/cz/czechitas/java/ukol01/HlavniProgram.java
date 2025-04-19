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
        zofka.setPenColor(Color.black);
        zofka.setPenWidth(4);

        //TODO implementace domácího úkolu
//        partOne();
//        partTwo();
        partThree();
        partFour();
    }

    // Part 1 - Pig
    public void partOne() {
        drawPiggy(100, 50);
    }

    // Part 2 - Geometric shapes
    public void partTwo() {
        moveToDefaultPosition(90, 140, Direction.LEFT, 90, 50, Direction.LEFT);
        drawCurve(8, 30, 45, Direction.RIGHT); // Octagon

        moveToDefaultPosition(90, 90, Direction.RIGHT, 90, 30, Direction.RIGHT);
        drawCurve(20, 12, 18, Direction.LEFT); // Circle

        moveToDefaultPosition(90, 180, Direction.LEFT, 90, 12, Direction.LEFT);
        drawCurve(20, 12, 18, Direction.LEFT); // Sun
        drawSunRays(20, 20, 6, 18);
    }

    // Part 3 - Village composition
    public void partThree() {
        drawPicture();
    }

    // Part 4 - Name
    public void partFour() {
        drawName();
    }

    private void moveToDefaultPosition(double firstAngle, double firstDistance, Direction firstDirection, double secondAngle, double secondDistance, Direction secondDirection) {
        zofka.penUp();
        turnAndMove(firstAngle, firstDistance, firstDirection);
        turnAndMove(secondAngle, secondDistance, secondDirection);
        zofka.penDown();
    }

    private void turnAndMove(double angle, double distance, Direction turn) {
        if (turn == Direction.RIGHT) {
            zofka.turnRight(angle);
        } else {
            zofka.turnLeft(angle);
        }
        zofka.move(distance);
    }

    private void moveTo(double x, double y) {
        zofka.penUp();
        zofka.setLocation(x, y);
        zofka.penDown();
    }

    // Pig drawing methods
    private void drawPiggy(double bodyLength, double bodyHeight) {
        turnAndMove(90, bodyLength, Direction.RIGHT); // top line of the body
        turnAndMove(90, bodyHeight, Direction.RIGHT); // right side of the body
        drawPigTail(bodyHeight);// pig tail of the body
        drawLegs(30); // back legs
        turnAndMove(120, bodyLength, Direction.LEFT);// bottom line of the body
        drawLegs(120); // front legs
        drawHead(90, Direction.LEFT, 120, Direction.RIGHT, 50); // head
        turnAndMove(120, bodyHeight, Direction.RIGHT); // left side of the body
    }

    private void drawPigTail(double sideLength) {
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

    private void drawLegs(double angle) {
        zofka.turnLeft(angle);
        zofka.move(40);
        zofka.penUp();
        zofka.turnRight(120);
        zofka.move(40);
        zofka.turnRight(120);
        zofka.penDown();
        zofka.move(40);
    }

    private void drawHead(double firstAngle, Direction firstTurn, double secondAngle, Direction secondTurn, double sideLength) {
        turnAndMove(firstAngle, sideLength, firstTurn);
        turnAndMove(secondAngle, sideLength, secondTurn);
    }

    // Geometric shapes
    private void drawCurve(int steps, double stepLength, double circleAngle, Direction circleDirection) {
        for (int i = 0; i < steps; i++) {
            turnAndMove(circleAngle, stepLength, circleDirection);
        }
    }

    private void drawSunRays(int steps, double rayLength, double circleStepLength, double circleAngle) {
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

    // Village composition
    private void drawPicture() {
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

        // Middle row
        moveTo(zofka.getX() + 50, 300);
        zofka.turnLeft(90);

        // Right house
        drawHouse(50, 70);

        // Piggy
        moveTo(zofka.getX() - 150, 300);
        zofka.turnRight(90);
        drawPiggy(70, 50);

        // Left house
        moveTo(300, 300);
        drawHouse(50, 70);

    }

    // House components
    private void drawHouse(double houseLength, double houseHeight) {
        drawBody(houseLength, houseHeight);
        drawRoof(houseLength);
    }

    private void drawBody(double houseLength, double houseHeight) {
        zofka.move(houseHeight);
        turnAndMove(90, houseLength, Direction.RIGHT);
        turnAndMove(90, houseHeight, Direction.RIGHT);
    }

    private void drawRoof(double houseLength) {
        drawHead(30, Direction.RIGHT, 120, Direction.RIGHT, houseLength);
        turnAndMove(120, houseLength, Direction.RIGHT);
    }

    // Name drawing
    private void drawName() {
        moveTo(300, 500);
        zofka.turnRight(90);
        drawS();

        // diacritics
        moveTo(zofka.getX() - 20, zofka.getY() - 20);
        drawLegs(190);

        moveTo(zofka.getX() + 30, 500);
        zofka.turnRight(150);
        drawA();

        // diacritics
        moveTo(zofka.getX() + 15, zofka.getY() - 40);
        turnAndMove(110, 30, Direction.RIGHT);

        moveTo(zofka.getX() + 30, 500);
        zofka.turnRight(-20);
        drawR();

        moveTo(zofka.getX() + 20, 500);
        zofka.turnLeft(140);
        drawK();

        moveTo(zofka.getX() + 10, 500);
        zofka.turnLeft(145);
        drawA();

        moveTo(zofka.getX() + 60, 500);
        zofka.turnRight(90);
    }

    // Letter components
    private void drawS() {
        turnAndMove(110, 15, Direction.RIGHT);
        for (int i = 0; i < 11; i++) {
            turnAndMove(20, 7, Direction.LEFT);
        }
        turnAndMove(50, 5, Direction.RIGHT);
        for (int i = 0; i < 11; i++) {
            turnAndMove(20, 7, Direction.RIGHT);
        }
    }

    private void drawA() {
        turnAndMove(20, 80, Direction.RIGHT);
        turnAndMove(140, 80, Direction.RIGHT);
        turnAndMove(180, 40, Direction.RIGHT);
        turnAndMove(70, 25, Direction.LEFT);
    }

    private void drawR() {
        zofka.move(60);
        drawCurve(20, 7, 16, Direction.RIGHT);
        turnAndMove(180, 60, Direction.RIGHT);
    }

    private void drawK() {
        zofka.move(80);
        turnAndMove(180, 40, Direction.RIGHT);
        turnAndMove(145, 48, Direction.LEFT);
        zofka.penUp();
        turnAndMove(180, 48, Direction.RIGHT);
        zofka.penDown();
        turnAndMove(70, 48, Direction.LEFT);
    }
}



