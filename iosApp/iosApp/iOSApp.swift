import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    init() {
        HelperKt.doInitKoin(context: IosContext())
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
