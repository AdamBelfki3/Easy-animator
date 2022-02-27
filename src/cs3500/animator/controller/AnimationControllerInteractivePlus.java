package cs3500.animator.controller;

import cs3500.animator.view.InteractiveViewPlus;

/**
 * We had to create a new controller in order for our interactive view with the plus method
 * to work. Additionally, this controller also implements the Features interface since this
 * assignment required us to have to additional features: outline shapes and making the frames
 * discrete.
 */
public class AnimationControllerInteractivePlus extends AnimationController
    implements IController, Features {

  /**
   * This constructor takes in the interactive view with all the new plus features implemented.
   * Then, it's passed in for the controller to call the execute method and render this view.
   */
  public AnimationControllerInteractivePlus(InteractiveViewPlus view) {
    super(view);
  }

  @Override
  public void outlineShapes() {
    this.view.outlineShapesView();
  }

  @Override
  public void discreteFrame() {
    this.view.discreteFrameView();
  }
}
