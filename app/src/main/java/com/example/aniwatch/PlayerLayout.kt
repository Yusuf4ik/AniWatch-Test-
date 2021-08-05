package com.example.aniwatch

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.aniwatch.ViewModels.CommonVM
import com.example.aniwatch.data.Utils
import com.example.aniwatch.data.Videos
import com.example.aniwatch.databinding.FragmentPlayerLayoutBinding


class PlayerLayout : Fragment() {
    private var _binding: FragmentPlayerLayoutBinding? = null
    private val binding get() = _binding!!
    private var isPlaying = true
    private lateinit var viewModel: CommonVM

    private val MEDIA_PATH = Environment.getExternalStorageDirectory().path + "/Internal storage/DClM/Camera/314ebc9b846acc6534519231c9572db7.mp4"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayerLayoutBinding.inflate(layoutInflater, container, false)
        return binding.root    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        anime()
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun anime() {
        binding.apply {
            webView.webViewClient = WebViewClient()
            webView.loadUrl("https://animego.org")
            webView.settings.javaScriptEnabled = true
            webView.webChromeClient = WebChromeClient()


        }
    }



}
