# ✦ PRIMO CALC ✦

> "One more pull surely won't hurt..." :3

A small Java project focused on tracking gacha progression, primogems, pity and pulling goals ☆

Currently made for:

- Genshin Impact ✦

Future plans:

- Honkai: Star Rail 🚄
- Zenless Zone Zero ⚡
- Other gacha games maybe...? >w<

---

# ✦ About

Primo Calc is a study-oriented Java project created to practice and connect multiple programming concepts through a subject I already enjoy.

The project started as a simple terminal application and gradually evolved while new concepts were learned and applied.

This is NOT intended to be a production-ready application.

Instead, it serves as:

⭐ a learning sandbox  
⭐ a portfolio of personal progress  
⭐ a place to experiment with architecture decisions  
⭐ a way to revisit older code and compare growth over time

---

# ✦ Technologies

☕ Java 21

📦 Maven

🗂 Jackson Databind

💻 VS Code

---

# ✦ Current Features

## 🌠 Account System

- Multiple accounts
- Balance tracking
- Pity tracking
- Goal assignment
- Progress calculation

## 🌌 Reward System

- Reward templates
- Account-specific reward instances
- Quantity support
- Redeemed progress tracking

## ✨ Goal System

- Goal templates
- Quantity multiplier support
- Remaining currency calculation
- Pull estimation

## 💾 Persistence System

- Save accounts to JSON
- Load accounts from JSON
- Save reward templates
- Load reward templates
- Save goal templates
- Load goal templates

## 🖥 Terminal UI

- Multi-screen navigation
- Dynamic menus
- Toggle-based reward selection
- Helper display methods
- Simple screen transitions

---

# ✦ Architecture

The project currently follows a simple layered structure:

```text
src/
└── main/
    └── java/
        └── primocalc/
            │
            ├── Main.java
            │
            ├── model/
            │     Account
            │     AccountGoal
            │     AccountRewardSource
            │     GoalTemplate
            │     RewardTemplate
            │
            ├── service/
            │     AccountService
            │     RewardService
            │     SaveService
            │
            └── menu/
                  Menu
```

---

# ✦ Current Version

```text
V3.0
```

### Codename

⭐ Maven Object Permanence ⭐

Main milestone:

- Migration to Maven
- Jackson integration
- JSON persistence
- Automatic loading/saving
- Better project organization

---

# ✦ What was learned so far

## ☕ Java

- Classes and Objects
- Encapsulation
- Constructors
- Composition
- Collections
- ArrayList
- Service Layer
- Separation of Responsibilities

## 📦 Maven

- Dependency Management
- Project Structure
- Build Lifecycle
- External Libraries

## 🗂 Jackson

- Serialization
- Deserialization
- JSON Mapping
- Object Persistence

---

# ✦ Planned Features

## 🚀 V3.x

- Better validation
- Safer loading process
- Data migration support
- Improved save structure

## 🌠 V4

- React Front-End
- REST API integration
- Better UX
- Cleaner architecture

## 🌌 Future

- Multi-game support
- Statistics dashboard
- Reward history
- Pull simulation
- Banner planner

---

# ✦ Why this project exists

This project mainly exists to:

- practice programming;
- learn new concepts;
- make mistakes and understand why they happen;
- connect studies with personal interests;
- keep a record of long-term improvement.

Every version intentionally preserves part of the learning journey.

Some solutions may not be perfect.

That's actually part of the point ☆

---

# ✦ Github

```text
original-dev:
your-github-name

repository:
https://github.com/your-user/your-repository
```

---

# ✦ Development Notes

Current persistence files:

```text
accounts.json
rewardTemplates.json
goalTemplates.json
```

These files are intended for local testing and may be ignored by Git depending on the project's needs.

---

# ✦ Status

Currently under development 🌠

The stars are not guaranteed...

but the pity system certainly is. ✦ >w<