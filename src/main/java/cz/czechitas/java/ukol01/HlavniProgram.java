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

        // 1.PART
        drawPig(100, 50);

        // 2.PART
        // Back to default position
        goToDefaultPosition(90, 140, 90, 50, Direction.LEFT);
        // Octagon
        drawOctagon();
        // Back to default position
        goToDefaultPosition(90, 90, 90, 30, Direction.RIGHT);
        // Circle
        drawCircle();
        //Back to default position
        goToDefaultPosition(90, 180, 90, 12, Direction.LEFT);
        // Sun
        drawCircle();
        drawSunRays();
    }

    public void goToDefaultPosition(double firstAngle, double firstDistance, double secondAngle, double secondDistance, Direction direction) {
        zofka.penUp();
        turnAndMove(firstAngle, firstDistance, direction);
        turnAndMove(secondAngle, secondDistance, direction);
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

    public void drawLegsPair(double angle) {
        zofka.turnLeft(angle);
        zofka.move(40);
        zofka.penUp();
        zofka.turnRight(120);
        zofka.move(40);
        zofka.turnRight(120);
        zofka.penDown();
        zofka.move(40);
    }

    public void drawPigHead() {
        zofka.turnLeft(90);
        zofka.move(50);
        zofka.turnRight(120);
        zofka.move(50);
    }

    public void drawPig(double bodyLength, double bodyHeight) {
        // top line of the body
        turnAndMove(90, bodyLength, Direction.RIGHT);
        // right side of the body
        turnAndMove(90, bodyHeight, Direction.RIGHT);
        // pig tail of the body
        drawPigTail(bodyHeight);
        // back legs
        drawLegsPair(30);
        // bottom line of the body
        turnAndMove(120, bodyLength, Direction.LEFT);
        // front legs
        drawLegsPair(120);
        // head
        drawPigHead();
        // left side of the body
        turnAndMove(120, bodyHeight, Direction.RIGHT);
    }

    // 2.PART
    public void drawOctagon() {
        for (int i = 0; i < 8; i++) {
            zofka.turnRight(45);
            zofka.move(30);
        }
    }

    public void drawCircle() {
        for (int i = 0; i < 20; i++) {
            zofka.turnLeft(18);
            zofka.move(12);
        }
    }

    public void drawSunRays() {
        boolean canDraw = true;
        for (int i = 0; i < 20; i++) {
            zofka.turnLeft(18);
            zofka.move(6);
            if (canDraw) {
                zofka.penDown();
                zofka.turnRight(90);
                zofka.move(20);
                zofka.penUp();
                zofka.turnLeft(180);
                zofka.move(20);
                zofka.turnRight(90);
            }
            zofka.move(6);
            canDraw = !canDraw;
        }
    }
}

