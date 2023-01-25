package model;

public enum State_Game {
  WAITING, PLAYING;


  private static State_Game currentStatus;

  public static boolean isGameState(State_Game status){
      return currentStatus == status;
  }

  public static State_Game getGameState(){
      return currentStatus;
  } 

  public static void setGameState(State_Game currentStatus) {
    State_Game.currentStatus = currentStatus;
  }
}