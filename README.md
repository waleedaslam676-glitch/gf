# Smart AI Assistant — Round 1 (Core App)

## Kya hai is round mein
- Home Screen (grid of main actions)
- Workflow Library (list, delete, empty state)
- Create Workflow (save to local Room database)
- Settings (placeholder — future rounds mein AI Providers, API Keys, Detection settings yahin aayenge)
- Room Database (workflows table)
- Navigation Compose se sab screens connected

## Abhi kya NAHI hai (agle rounds mein aayega)
- Screenshot + Red Circle Annotation System
- Workflow Recorder/Player (tap/swipe/type automation)
- OCR / Vision Detection Engine
- AI Provider Integration (Gemini/OpenAI/etc.)
- Voice Command System
- Smart Automation Builder (no-code trigger/condition/action)

## APK Kaise Banayein (GitHub se)

1. GitHub par ek naya empty repository banao.
2. Is zip ke andar ka **poora content** (folders + files) us repo mein upload/push karo.
   - Root mein `build.gradle.kts`, `settings.gradle.kts`, `app/` folder, `.github/` folder — sab honi chahiye repo ke root mein.
3. Repo ke "Actions" tab mein jao — `Build APK` workflow apne aap chalega (push hote hi).
4. Workflow complete hone ke baad, us run ke "Artifacts" section mein `app-debug-apk` milega — usko download karo, andar `app-debug.apk` hoga.
5. Wahi APK apne Android phone mein install karo (Unknown Sources allow karna padega).

## Agla Round
Jab ye APK test kar lo aur koi error/mismatch mile, ya agla feature batana ho, to bata dena — usi project mein add karke naya zip milega.
