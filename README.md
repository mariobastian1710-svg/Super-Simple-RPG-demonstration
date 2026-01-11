# Super-Simple-RPG-demonstration

Nama Aplikasi :
Super Simple RPG

Deskripsi Singkat :
Simple RPG Game adalah aplikasi game berbasis Java console yang dibuat untuk menerapkan konsep Object-Oriented Programming (OOP).
Pemain dapat memilih karakter, bertarung melawan musuh, menggunakan item, serta menyimpan dan memuat progres permainan melalui file.

Menggunakan cara menjalankan aplikasi
1. Extract folder project
2. Buka project di IntelliJ IDEA / Eclipse
3. Jalankan file `Main.java`

Fitur Utama :
- Pemilihan karakter (Warrior, Mage, Archer)
- Sistem pertarungan turn-based
- Item & inventory menggunakan ArrayList
- Save & Load game ke file

Daftar Class dan Fungsinya :
1. Main  
Class utama untuk menjalankan game. Berisi method `main()`.
2. PlayerMenu 
Mengatur menu game seperti New Game, Load Game, dan alur permainan.
3. Character (Abstract Class)  
Class dasar untuk semua karakter. Menyimpan atribut umum seperti nama, HP, dan attack.
4. Warrior  
Karakter pemain dengan serangan jarak dekat dan HP besar.
5. Mage 
Karakter pemain dengan serangan sihir dan damage tinggi.
6. Archer
Karakter pemain dengan serangan jarak jauh.
7. Enemy (Abstract Class)  
Class dasar untuk semua musuh dalam game.
8. Skeleton
Musuh level awal dengan HP dan damage kecil.
9. Skeleton Captain
Musuh level awal dengan HP dan damage sedang.
10. Skeleleton Dragon 
Musuh boss dengan HP dan damage besar.
11. Battle 
Mengatur proses pertarungan antara player dan musuh.
12. AttackStrategy (Interface)  
Interface yang mendefinisikan cara karakter menyerang tanpa karakter tersebut mengetahui detail serangan yang digunakan.
13. MeleeAttack, RangedAttack, SpellAttack  
Implementasi berbagai jenis serangan.
14. Item (Abstract Class)  
Class dasar untuk item dalam game.
15. HealthPotion  
Item untuk menambah HP pemain.
16. StrengthPotion  
Item untuk meningkatkan kekuatan serangan pemain.
17. StatusEffect (Interface)  
Interface yang mendefinisikan berbagai efek-efek yang dapat terjadi pada karakter.
18. StrengthBuff
Efek untuk meningkatkan kekuatan (ATK) karakter untuk durasi tertentu.
20. GameSaveManager  
Mengatur penyimpanan dan pemuatan data game ke file.

Penerapan Konsep OOP :
- Encapsulation: atribut private dengan getter/setter
- Inheritance: turunan Character dan Enemy
- Polymorphism: AttackStrategy
- Abstraction: abstract class dan interface
