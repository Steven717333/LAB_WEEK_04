package com.example.lab_week_04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_list, container, false) // Ensure you have fragment_list.xml
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val affogatoView = view.findViewById<View>(R.id.affogato)
        val americanoView = view.findViewById<View>(R.id.americano)
        val latteView = view.findViewById<View>(R.id.latte)

        val coffeeList = listOfNotNull( // Use listOfNotNull to avoid issues if a view is not found
            affogatoView,
            americanoView,
            latteView
        )

        coffeeList.forEach { coffee ->
            val fragmentBundle = Bundle().apply {
                putInt(COFFEE_ID, coffee.id)
            }
            coffee.setOnClickListener(
                Navigation.createNavigateOnClickListener(
                    R.id.action_listFragment_to_detailFragment,
                    fragmentBundle
                )
            )
        }
    }

    companion object {
        const val COFFEE_ID = "COFFEE_ID"
    }
}
