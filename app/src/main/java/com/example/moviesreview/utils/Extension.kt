package com.example.moviesreview.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

inline fun<T : ViewDataBinding> T.executeAfter(block: T.() -> Unit) {
    block()
    executePendingBindings()
}

inline fun Fragment.launchAndRepeatOnLifecycle(mainActiveState: Lifecycle.State = Lifecycle.State.STARTED,
                                               crossinline block: suspend CoroutineScope.() -> Unit) {
    viewLifecycleOwner.lifecycleScope.launch {
        viewLifecycleOwner.lifecycle.repeatOnLifecycle(mainActiveState) {
               block()
        }
    }
}

@BindingAdapter("android:imageSrc")
fun setImageSource(imageView: ImageView, posterUrl: String) {
    Glide
        .with(imageView.context)
        .load("https://image.tmdb.org/t/p/w500$posterUrl")
        .centerCrop()
        .thumbnail(0.5f)
        .into(imageView);
}