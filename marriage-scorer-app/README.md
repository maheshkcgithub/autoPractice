# Marriage Scorer — Android app

Native wrapper around the single-file `marriage-scorer.html` scorekeeper,
built with [Capacitor](https://capacitorjs.com/). UI and scoring logic are
untouched — the only functional addition is persistent storage, via
Capacitor's `Preferences` plugin, so closing the app no longer loses players,
rules, or round history.

## What's here

```
marriage-scorer-app/
├── www/index.html          the app (same markup/CSS/logic as the original,
│                            plus load/save calls into Capacitor Preferences)
├── src/native-bridge.js     bundled into www/capacitor-bridge.js; exposes
│                            the Preferences plugin as window.CapacitorPreferences
├── resources/                source icon art (see below)
├── android/                  the generated native Android project
├── capacitor.config.json
└── scripts/generate-icons.js  regenerates resources/icon-*.png from the
                                 app's green/gold/cream "M" mark
```

Persistence: `www/index.html` serializes the whole in-memory `state` object
(players, rules, rounds, current round draft, theme) to Capacitor Preferences
on every render and on every field edit (debounced ~250ms), and restores it
on launch before the first render.

App icon: generated from the exact mark already embedded in the original
HTML's favicon/apple-touch-icon (`#0f3d2e` green, `#c9a24b` gold ring,
`#f4ecd8` cream "M"). Full Android icon set (legacy, round, and adaptive
foreground/background layers for every density) is already generated under
`android/app/src/main/res/mipmap-*`. Re-run `npm run gen:icons && npx
capacitor-assets generate --android` if you ever change the mark.

## ⚠️ Build status in this environment

Everything up through generating the native Android project, its icons,
and syncing the web assets into `android/` is done and committed — you do
**not** need Node.js just to build and install the app. The actual
`gradlew assembleDebug` **could not be completed in this sandbox** though:
this environment's outbound network is proxied and only allows a fixed
allowlist of hosts (npm registry, PyPI, etc.) — `dl.google.com` (Google's
Maven repo, where the Android Gradle Plugin and all AndroidX/Jetpack
dependencies live) returns `403 Forbidden` through that proxy, and there's
no Android SDK installed here either. So the Gradle build has never
actually been run to completion or verified against a device from this
session — you'll need to do that step yourself, per below.

## Finishing the build (on your own machine)

**Only Android Studio is required** — `android/app/src/main/assets/public`
already contains the synced, ready-to-build copy of the app (committed to
the repo, not regenerated at build time), so Node.js is only needed if you
go on to edit `www/index.html` or `src/native-bridge.js` yourself later
(see below).

1. Install [Android Studio](https://developer.android.com/studio) (it
   bundles a JDK and manages the Android SDK download for you — this is
   the step that needs network access to Google's servers, which this
   sandbox didn't have).
2. `git clone` this repo, then in Android Studio choose **Open** and pick
   the `marriage-scorer-app/android` folder.
3. Let it finish Gradle sync (first run downloads the Android Gradle
   Plugin + AndroidX libraries — this is what actually needs that network
   access).
4. Plug in your phone via USB with **USB debugging** enabled (Settings →
   About phone → tap "Build number" 7×  → enables Developer Options →
   turn on USB debugging), pick it as the run target in the toolbar
   dropdown, and hit **Run** (▶). Or `Build > Generate Signed/Debug APK`
   if you'd rather install it manually.

No developer account, Play Store, or root needed — this is exactly the
"sideload onto my phone" path from the handoff doc.

**CLI alternative**, if you have the Android SDK set up without Studio:
```bash
cd android
./gradlew assembleDebug
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

### If you want to edit the app itself

`www/index.html` is the actual source; `android/app/src/main/assets/public`
is just its last synced copy. After changing `www/index.html` or
`src/native-bridge.js`, you do need Node.js to regenerate that copy:

```bash
npm install       # one-time
npm run sync       # rebuilds capacitor-bridge.js and re-copies www/ into android/
```
Then rebuild in Android Studio (or `./gradlew assembleDebug`) as above.

## Notes carried over from the handoff

- **"Point ko Daam"** field on the setup screen is intentionally decorative
  — it's stored but not read by the scoring formula. Left as-is.
- Scoring formula, 3-step wizard flow, and all UI are unchanged from
  `marriage-scorer.html` — see the original handoff doc for the full spec
  (winner/Maal/Dublee mechanics, zero-sum scoring math).
- iOS wrapping and Play Store packaging are optional/later steps per the
  handoff and weren't attempted here (no Mac/Xcode in this environment
  either) — `npx cap add ios` from a Mac with Xcode is the next step if
  you want that later.
