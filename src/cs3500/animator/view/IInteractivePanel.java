package cs3500.animator.view;

/**
 *  Contains all the methods that are implemented by all the interactive panels in the animation.
 *  By doing so, we can easily provide these features to the different interactive panels
 *  if we want as well.
 */
public interface IInteractivePanel extends IAnimationPanels {

  /**
   * Gives the shapes in the panel the ability to either be displayed in an outline or be
   * filled with color.
   */
  public void outlineShapesPanel();

  /**
   * Uses the panel in order to separate each of the frames in discrete frames so that
   * we are able to see the animation in discrete frames as opposed to a continuous animation.
   */
  public void discreteFramePanel();
}

