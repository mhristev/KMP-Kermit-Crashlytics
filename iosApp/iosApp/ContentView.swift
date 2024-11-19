import SwiftUI
import Shared
import FirebaseCrashlytics

final class CrashManager {
    
    static let shared = CrashManager()
    private init() { }
    
    func setUserId(userId: String) {
        Crashlytics.crashlytics().setUserID(userId)
    }
}


struct ContentView: View {
    
    var body: some View {
        VStack {
            Button("Trigger crash out of bounds in the shared code again") {
                SharedLogger().logInfo(message: "I am trying to trigger a crash with out of bounds from the iOS application.")
                CrashSimulator().triggerCrashOutOfBounds()
            }
        }
        .onAppear {
            CrashManager.shared.setUserId(userId: "USER123")
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .top)
        .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
