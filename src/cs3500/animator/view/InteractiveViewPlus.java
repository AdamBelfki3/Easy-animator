package cs3500.animator.view;

import cs3500.animator.controller.Features;
import cs3500.animator.model.IViewModel;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


/**
 * This class adds additional interactivity feature to the interactive view by adding
 * more methods such as the ability to outline a shape, slow motion and display discrete
 * frames of the animation. These new features  will be called on using the buttons and keys.
 * For example, the o key will display the shape in an outline, the d key will toggle between
 * the discrete and continuous animation. Similarly, the buttons with those
 * titles will perform the corresponding actions.
 */
public class InteractiveViewPlus extends InteractiveVisualAnimationView
    implements IVisualAnimationView {

  /**
   * A constructor that takes in the view model and speed so that we are able to pass in the
   * view model in the delegate since we want this view to have all the same features as the
   * visual view without having to re do all the methods that already exist there.
   * Additionally, it also has objects of the panel and frame classes so that
   * we are able to access both of those fields and use them to implement this class.
   * @param viewModel the model that we want to be interactive we would pass it in this constructor
   * @param speed the speed at which we would want our interactive animation to render at
   */
  public InteractiveViewPlus(IViewModel viewModel, int speed) {
    super(Objects.requireNonNull(viewModel), speed);
    this.panel = new InteractivePanelPlus(viewModel, speed);
    this.frame = new InteractiveFramePlus((InteractivePanelPlus) this.panel,
      viewModel.getWidthCanvas(),
        viewModel.getHeightCanvas());
    this.delegate = new VisualAnimationView(this.panel, this.frame, viewModel);
  }

  protected InteractiveViewPlus() {
    // this view is used in order to construct the mock view
  }

  public void outlineShapesView() {
    this.panel.outlineShapesPanel();
  }

  public void discreteFrameView() {
    this.panel.discreteFramePanel();
  }

  /**
   * Configures each button with a corresponding feature to give that button that
   * feature ability once the button is pressed. The buttons are being placed with a
   * feature in a map using lambda so that the code is cleaner.
   * @param feat the features which contains the methods that is being applied to to each button
   */
  @Override
  protected void configureButtonListener(Features feat) {
    if (feat == null) {
      throw new IllegalArgumentException("features object cannot be null");
    }

    Map<String,Runnable> buttonClickedMap = new HashMap<String,Runnable>();
    ButtonListener buttonListener = new ButtonListener();

    buttonClickedMap.put("restart", () -> feat.restartAnimation());
    buttonClickedMap.put("pause", () -> feat.pauseAnimation());
    buttonClickedMap.put("start", () -> feat.beginAnimation());
    buttonClickedMap.put("resume", () -> feat.resumeAnimation());
    buttonClickedMap.put("fast forward", () -> feat.fastForward(2));
    buttonClickedMap.put("fast backward", () -> feat.fastBackward(2));
    buttonClickedMap.put("loop", () -> feat.loopAnimation());
    // outline shape feature
    buttonClickedMap.put("outline", () -> feat.outlineShapes());

    // discrete to continuous button feature
    buttonClickedMap.put("discrete", () -> feat.discreteFrame());

    buttonListener.setButtonClickedActionMap(buttonClickedMap);
    this.frame.addActions(buttonListener);
  }

  /**
   * Configures each key press with a corresponding feature to give that key that feature
   * ability. The keys are being place with feature in a map using lambda so that the code
   * is cleaner.
   * @param feat the features which contains the methods that is being applied to to each key
   */
  @Override
  protected void configureKeyBoardListener(Features feat) {
    if (feat == null) {
      throw new IllegalArgumentException("features object cannot be null");
    }

    Map<Integer, Runnable> keyPresses = new HashMap<>();

    // key features
    // start
    keyPresses.put(KeyEvent.VK_S, () -> feat.beginAnimation());
    // pause
    keyPresses.put(KeyEvent.VK_P, () -> feat.pauseAnimation());
    // resume
    keyPresses.put(KeyEvent.VK_R, () -> feat.resumeAnimation());
    // restart
    keyPresses.put(KeyEvent.VK_E, () -> feat.restartAnimation());
    //quit
    keyPresses.put(KeyEvent.VK_Q, () -> System.exit(0));
    // arrow left
    keyPresses.put(KeyEvent.VK_N, () -> feat.fastBackward(2));

    // arrow right
    keyPresses.put(KeyEvent.VK_M, () -> feat.fastForward(2));

    // arrow right
    keyPresses.put(KeyEvent.VK_L, () -> feat.loopAnimation());

    // press o for outline
    keyPresses.put(KeyEvent.VK_O, () -> feat.outlineShapes());

    // press d for discrete
    keyPresses.put(KeyEvent.VK_D, () -> feat.discreteFrame());

    KeyListeners kbd = new KeyListeners();
    kbd.setKeyPressedMap(keyPresses);

    this.panel.addKeyListener(kbd);

    // keys won't work without this
    this.panel.setFocusable(true);
  }

}
