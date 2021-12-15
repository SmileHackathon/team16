package jp.ac.`fun`.hackathon.santaclaushasfallen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View//画面遷移に必要なインポート
import android.content.Intent//画面遷移に必要なインポート
import android.media.MediaPlayer//MediaPlayerをつかえるようにする

class SubActivity : AppCompatActivity() {
    lateinit var mp1:MediaPlayer//MediaPlayerの使用を定義する
    private var M=3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        mp1= MediaPlayer.create(this,R.raw.gameing)//gameingというBGMを読み込む
        mp1.isLooping=true//BGMをループする
        mp1.start()//BGMをスタートする


    }




     //ボタンを押したとき
     fun onButtonTapped(view: View?) {


             if (M >= 1) {
                 M -= 1//距離が

             } else {
                 val intent = Intent(this, clear::class.java)//距離が０になったらclearにとぶ
                 startActivity(intent)
                 mp1.release()//BGMを終了する
             }
         }
     }
//         val intent = Intent(this, clear::class.java)
//         startActivity(intent)
//         val play_susumu_button: Button? = findViewById(R.id.play_susumu_button)
//         //１）画面遷移
//         play_susumu_button?.setOnClickListener {
//             //５）条件分岐
//}


