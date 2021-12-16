package com.example.myapplication

import android.animation.ObjectAnimator
import android.media.Image
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class SubActivity : AppCompatActivity() {
    private var santa: ImageView? = null //サンタの画像
    private var movement: Button? = null //動くボタン
    private var distance: TextView? = null //距離の表示
    private var d: Int = 100// 距離
    private var u: Int = 0// あとで足して使う座標の変数
    private var text: String? = null //変換のための変数。
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        santa = findViewById(R.id.santa) //サンタ画像の代入
        distance = findViewById(R.id.Distance) //距離のテキストの代入
        movement = findViewById(R.id.button) //ボタンが押されたとき
            val move: View = findViewById(R.id.santa)
            movement?.setOnClickListener {
                if (d > 0) {
                    //クリックしたとき
                    d--//距離を近づける]
                    u+=1
                    ObjectAnimator.ofFloat(move, "translationX", u*5f, u*5+5f).apply{//サンタの画像のx座標を変える
                        //引数はそれぞれサンタの画像のImageView、プロパティ名、
                        duration = 1//移動にかかる時間
                        start()
                    }
                    ObjectAnimator.ofFloat(move, "translationY", u*8f, u*8+8f).apply {//サンタの画像のy座標を変える
                        duration = 1
                        start()
                    }
                    text = d.toString()//文字列データに変換し
                    distance?.text = text //テキストに反映
                } else if (d == 0) {
                    Log.d("MainActivity", "clear")//デバック
                }
            }
    }
}
