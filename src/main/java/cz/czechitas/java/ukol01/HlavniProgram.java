package cz.czechitas.java.ukol01;

import cz.czechitas.java.ukol01.engine.Turtle;

public class HlavniProgram {
  private Turtle zofka;

  public enum Direction{
    LEFT, RIGHT
  }
  public static void main(String[] args) {
    new HlavniProgram().start();
  }

  public void start() {
    zofka = new Turtle();

    //TODO implementace domácího úkolu
    drawPig(100, 50);
  }

  public void turnAndMove(double angle, double pixels, Direction turn){
   switch(turn){
     case RIGHT:
       zofka.turnRight(angle);
       break;
     case LEFT:
       zofka.turnLeft(angle);
       break;
   }
    zofka.move(pixels);
  }

  public void drawPigTail(double sideLength){
    zofka.penUp();
    zofka.move(- sideLength / 2);
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

  public void drawLegsPair(double angle){
    zofka.turnLeft(angle);
    zofka.move(40);
    zofka.penUp();
    zofka.turnRight(120);
    zofka.move(40);
    zofka.turnRight(120);
    zofka.penDown();
    zofka.move(40);
  }

  public void drawPigHead(){
    zofka.turnLeft(90);
    zofka.move(50);
    zofka.turnRight(120);
    zofka.move(50);
  }
  public void drawPig(double bodyLength, double bodyHeight){
    // top line of the body
    turnAndMove(90, bodyLength, Direction.RIGHT);
    // right side of the body
    turnAndMove(90,bodyHeight, Direction.RIGHT);
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
}

