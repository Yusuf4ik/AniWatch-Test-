package com.example.aniwatch

import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
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
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        _binding = FragmentPlayerLayoutBinding.inflate(layoutInflater, container, false)
        return binding.root    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val uriPath = "https://api.anilibria.tv/v2/getTitle?id=8500/videos/ts/8500/0001/playlist.m3u8"
        val uri = Uri.parse(uriPath)
        binding.videoView.setVideoURI(uri)
        binding.videoView.requestFocus()
        playersActivity()
//        viewModel = ViewModelProvider(this).get(CommonVM::class.java)
//         val ListVideos:MutableList<Videos>
//        viewModel.liveDataAnimes.observe(viewLifecycleOwner, {
//        })


    }
  fun  playersActivity(){
      binding.playBig.setOnClickListener{
          if (!isPlaying){
              isPlaying = true
              binding.videoView.start()
              binding.playBig.animate().alpha(0f).duration = 500
              binding.playBig.setImageResource(R.drawable.ic_baseline_pause_24)
              binding.play.setImageResource(R.drawable.ic_baseline_pause_24)
          }else if(isPlaying){
              isPlaying = false
              binding.videoView.stopPlayback()
              binding.playBig.animate().alpha(1f).duration = 500
              binding.playBig.setImageResource(R.drawable.ic_baseline_play_arrow_24)
              binding.play.setImageResource(R.drawable.ic_baseline_play_arrow_24)
          }

      }

      binding.videoView.setOnClickListener {
          if (binding.fullscreen.visibility == View.VISIBLE) {
              binding.fullscreen.animate().alpha(0f).duration = 500
              binding.fullscreen.visibility = View.GONE
              binding.play.animate().alpha(0f).duration = 500
              binding.play.visibility = View.GONE
              binding.seekBar.animate().alpha(0f).duration = 500
              binding.seekBar.visibility = View.GONE

          }else if(binding.fullscreen.visibility == View.GONE){
              binding.fullscreen.animate().alpha(1f).duration = 500
              binding.fullscreen.visibility = View.VISIBLE
              binding.play.animate().alpha(1f).duration = 500
              binding.play.visibility = View.VISIBLE
              binding.seekBar.animate().alpha(1f).duration = 500
              binding.seekBar.visibility = View.VISIBLE
          }
      }

      binding.play.setOnClickListener {
          if(!isPlaying){
              isPlaying = true
              binding.videoView.start()
              binding.play.animate().alpha(0f).duration = 500
              binding.play.setImageResource(R.drawable.ic_baseline_pause_24)
          }else if(isPlaying){
              isPlaying = false
              binding.videoView.stopPlayback()
              binding.play.animate().alpha(1f).duration = 500
              binding.play.setImageResource(R.drawable.ic_baseline_play_arrow_24)
          }
      }
      binding.fullscreen.setOnClickListener {
          Toast.makeText(requireContext(), "Pls wait a little", Toast.LENGTH_SHORT).show()
          findNavController().navigate(R.id.action_playerLayout_to_lansdcapeFragment)
      }
    }
}
