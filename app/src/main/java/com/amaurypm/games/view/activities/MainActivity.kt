package com.amaurypm.games.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.amaurypm.games.databinding.ActivityMainBinding
import com.amaurypm.games.model.Game
import com.amaurypm.games.model.StudentHP
import com.amaurypm.games.network.HPApi
import com.amaurypm.games.network.RetrofitService
import com.amaurypm.games.utils.Constants
import com.amaurypm.games.view.adapters.GamesAdapter
import com.amaurypm.games.view.adapters.StudentsAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val call = RetrofitService.getRetrofit().create(HPApi::class.java)
            .getStudents("api/characters")

        call.enqueue(object : Callback<ArrayList<StudentHP>> {
            override fun onResponse(
                call: Call<ArrayList<StudentHP>>,
                response: Response<ArrayList<StudentHP>>
            ) {
                binding.pbConexion.visibility = View.GONE

                Log.d(Constants.LOGTAG, "Respuesta del servidor: ${response.toString()}")

                Log.d(Constants.LOGTAG, "Datos: ${response.body().toString()}")

                binding.rvMenu.layoutManager = LinearLayoutManager(this@MainActivity)
                binding.rvMenu.adapter = StudentsAdapter(this@MainActivity, response.body()!!) { selectedGame: StudentHP ->
                    gameClicked(selectedGame)
                }

            }

            override fun onFailure(call: Call<ArrayList<StudentHP>>, t: Throwable) {
                binding.pbConexion.visibility = View.GONE
                Toast.makeText(this@MainActivity, "No hay conexión", Toast.LENGTH_SHORT).show()
            }

        })


    }

    private fun gameClicked(game: StudentHP) {
        /*Toast.makeText(this, "Clic en el elemento con títiulo ${game.title}", Toast.LENGTH_SHORT)
            .show()*/

        val bundle = Bundle()

        bundle.putString("id", game.id)

        val intent = Intent(this, Details::class.java)

        intent.putExtras(bundle)

        startActivity(intent)
    }
}