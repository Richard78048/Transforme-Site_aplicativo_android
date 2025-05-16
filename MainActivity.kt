package com.example.programacao_web_fmp

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val decorView = window.decorView
        // Esconde tanto a barra de navegação e a barra de status .
        // Esconde tanto a barra de navegação e a barra de status .
        val uiOptions = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
        decorView.systemUiVisibility = uiOptions
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.navegador)

        // Habilita JavaScript (se necessário)
        webView.settings.javaScriptEnabled = true

        // Configura o WebViewClient para interceptar links
        webView.webViewClient = WebViewClient()

        // Carrega a URL
        webView.loadUrl("https://aulas-fmp.free.nf/?i=1")

        // Verifica se há um estado salvo; se não houver, carrega a URL inicial

        if (savedInstanceState == null) {
            webView.loadUrl("https://aulas-fmp.free.nf/?i=1")
        } else {
            // Se houver um estado salvo, restaura o estado da WebView
            webView.restoreState(savedInstanceState)
        }

    }
    // Método chamado para salvar o estado da atividade antes de ser destruída
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Salva o estado atual da WebView no Bundle passado
        webView.saveState(outState)
    }
}