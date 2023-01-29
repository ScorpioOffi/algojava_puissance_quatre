package model;

public enum State_Game {
  WAITING, PLAYING;


  private static State_Game currentStatus;

  /**
   * Action spécifique selon le statut du jeu qui est enc ours
   * @param status
   * @return
   */
  public static boolean isGameState(State_Game status){
      return currentStatus == status;
  }

  /**
   * Récupérer le statut du jeu
   * @return
   */
  public static State_Game getGameState(){
      return currentStatus;
  }

  /**
   * Définir le status du jeu
   * @param currentStatus
   */
  public static void setGameState(State_Game currentStatus) {
    State_Game.currentStatus = currentStatus;
  }
}