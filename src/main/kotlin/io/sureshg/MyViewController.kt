package io.sureshg

import org.robovm.apple.coregraphics.CGRect
import org.robovm.apple.uikit.*

/**
 * Root view controller.
 *
 * @author Suresh
 */
class MyViewController : UIViewController() {

    private val button: UIButton
    private val label: UILabel
    private var clickCount: Int = 0

    init {
        // Get the view of this view controller.
        val view = view

        // Setup background.
        view.backgroundColor = UIColor.white()

        // Setup label.
        label = UILabel(CGRect(20.0, 250.0, 280.0, 44.0)).apply {
            font = UIFont.getSystemFont(24.0)
            textAlignment = NSTextAlignment.Center
        }

        // Setup button.
        button = UIButton(UIButtonType.RoundedRect).apply {
            frame = CGRect(110.0, 150.0, 100.0, 40.0)
            setTitle("Click me!", UIControlState.Normal)
            titleLabel.font = UIFont.getBoldSystemFont(22.0)
        }
        button.addOnTouchUpInsideListener { control, event -> label.text = "Hello Kotlin - " + ++clickCount }

        view.addSubview(label)
        view.addSubview(button)
    }
}
