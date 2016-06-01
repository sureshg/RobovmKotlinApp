package io.sureshg

import org.robovm.apple.coregraphics.CGRect
import org.robovm.apple.dispatch.DispatchQueue.getMainQueue
import org.robovm.apple.uikit.*
import java.util.*
import java.util.concurrent.TimeUnit.MILLISECONDS

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

        button.addOnTouchUpInsideListener { control, event ->
            label.text = "Hello Kotlin - ${++clickCount}"
            displayToast(Calendar.getInstance().time.toString())
        }

        view.addSubview(label)
        view.addSubview(button)
    }

    /**
     * Show toast message.
     *
     * @param message message to be displayed.
     */
    fun displayToast(message: String) {
        val alert = UIAlertController("Clicked!", message, UIAlertControllerStyle.ActionSheet)
        presentViewController(alert, true) {
            getMainQueue().after(200, MILLISECONDS) {
                alert.dismissViewController(true) {}
            }
        }
    }
}
