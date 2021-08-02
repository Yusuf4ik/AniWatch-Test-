package com.example.aniwatch
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.aniwatch.databinding.LandscapeBinding


class LansdcapeFragment : Fragment() {
    private var isPlaying = true
    private var _binding: LandscapeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View{
        // Inflate the layout for this fragment
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        _binding = LandscapeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        playersActivity()
    }
    private fun  playersActivity(){
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