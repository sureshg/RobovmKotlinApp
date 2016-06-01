package io.sureshg

import org.robovm.apple.foundation.NSAutoreleasePool
import org.robovm.apple.uikit.*

/**
 * Application main class.
 *
 * @author Suresh
 */
class Main : UIApplicationDelegateAdapter() {

    lateinit var win: UIWindow;
    lateinit var rootViewController: MyViewController

    override fun didFinishLaunching(application: UIApplication?, launchOptions: UIApplicationLaunchOptions?): Boolean {
        // Set up the view controller.
        rootViewController = MyViewController()
        // Create a new window at screen size.
        win = UIWindow(UIScreen.getMainScreen().bounds).apply {
            // Set the view controller as the root controller for the window.
            rootViewController = this@Main.rootViewController
            // Make the window visible.
            makeKeyAndVisible()
        }
        return true
    }

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            NSAutoreleasePool().apply {
                UIApplication.main<UIApplication, Main>(args, null, Main::class.java)
                close()
            }
        }
    }
}

