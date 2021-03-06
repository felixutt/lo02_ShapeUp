package core;
/**
 * Defines a class that can keep a reference to a {@link core.GameMaster} object in order to be notified of any change in the game handled by the {@link core.GameMaster}.
 * Implements by the observers of the model in the MVC pattern.
 * This unique method can notify of any change in the game and is handled by the GameMaster.
 */
public interface Observer {
    public void update(GameMaster gameMaster, Update arg);
}
