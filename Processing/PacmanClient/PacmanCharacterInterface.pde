public interface PacmanCharacterInterface {
  
  public int getxLoc();
  public int getyLoc();
  public int getSizeFactor();
  public int getDirection();
  public color getColour();
  public boolean isAlive();
  public void setxLoc(int xLoc);
  public void setyLoc(int yLoc);
  public void setSizeFactor(int sizeFactor);
  public void setDirection(int direction);
  public void setColour(color colour);
  public void setAlive(boolean alive);
  public void illustrate();
  public void moveLeft();
  public void moveRight();
  public void moveUp();
  public void moveDown();
  
}
