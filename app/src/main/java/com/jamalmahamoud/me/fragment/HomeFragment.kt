package com.jamalmahamoud.me.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jamalmahamoud.me.R
import com.jamalmahamoud.me.activity.child.ExerciseslAcitvity
import com.jamalmahamoud.me.databinding.FragmentHomeBinding
import com.jamalmahamoud.me.model.Exercises
import com.jamalmahamoud.me.model.Goals
import com.jamalmahamoud.me.model.StepsforPractise
import com.jamalmahamoud.me.model.ViewsAndAspirations
import com.jamalmahamoud.me.recycleview.ExercisesAdapter
import com.jamalmahamoud.me.recycleview.ViewAndAspirationAdapter

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        settingUpExercisesAndGoalAdapter()
        settingUpViewAndAspiration()
        binding.buttonTellMeHow.setOnClickListener {

        }



    }


    private fun settingUpExercisesAndGoalAdapter() {

        val goalListCommunication = listOf(
            Goals(
                "Eye Contact",
                "Learn how to maintain eye contact when speaking to people",
                listOf(
                    StepsforPractise(
                        "Practicing in the mirror",
                        "Start off by practicing in the mirror, it easier look yourself in the eyes ",
                        1,false,R.raw.praticeinthemirror
                    ),
                    StepsforPractise(
                        "Hold your gaze for 10 seconds",
                        "Hold your gaze for 10 seconds at a time and do it 3x.",
                        3,false,R.raw.holdyougaze
                    ),
                    StepsforPractise(
                        "Make eye contact ",
                        "Make eye contact with your favourite tv characters or YouTubers",
                        3,false,R.raw.youtuber
                    ),
                    StepsforPractise(
                        " Maintaining eye contact with me ",
                        "Or Play this video once more while maintaining eye contact with a cartoon character and try to keep eye contact for 3 seconds at a time",
                        3,false,R.raw.amazingperson
                    ),
                    StepsforPractise(
                        "Try it with someone ",
                        "After these exercises you are prepared to try it with someone you know.Once you've done this, take some time to think about how this made you feel. Excited? Scared? Happy",
                        3,false,R.raw.trywithmum
                    ),

                ),
                R.raw.eyecontact,
                4,R.raw.intro),
            Goals(
                "Eye Contact",
                "Learn how to maintain eye contact when speaking to people",
                listOf(
                    StepsforPractise(
                        "Practicing in the mirror",
                        "Start off by practicing in the mirror, it easier look yourself in the eyes ",
                        1,false,null
                    ),
                    StepsforPractise(
                        "Hold your gaze for 10 seconds",
                        "Hold your gaze for 10 seconds at a time and do it 3x.",
                        3,false,null
                    ),
                    StepsforPractise(
                        "Make eye contact ",
                        "Make eye contact with your favourite tv characters or YouTubers",
                        3,false,null
                    ),
                    StepsforPractise(
                        " Maintaining eye contact with me ",
                        "Or Play this video once more while maintaining eye contact with a cartoon character and try to keep eye contact for 3 seconds at a time",
                        3,false,null
                    ),
                    StepsforPractise(
                        "Try it with someone ",
                        "After these exercises you are prepared to try it with someone you know.",
                        3,false,null
                    ),
                    StepsforPractise(
                        "Once you've done this",
                        "Once you've done this, take some time to think about how this made you feel. Excited? Scared? Happy",
                        3,false,null
                    ),
                ),
                R.raw.eyecontact,
                4,null
            )
        )

        val goalListSocial = listOf(
            Goals(
                "Start Conversation",
                "learn how to start a conversations",
                listOf(
                    StepsforPractise(
                        "Start by practicing in the mirror",
                        "Start by practicing in the mirror. Can you think of a situation where you really wanted to talk to someone, but didn't?",
                        1,false,null
                    ),

                    StepsforPractise(
                        "Think about what you wanted to say",
                        "Start by practicing in the mirror. Can you think of a situation where you really wanted to talk to someone, but didn't?",
                        1,false,null
                    ),

                    StepsforPractise(
                        "What would you say next",
                        "What would you say next, for example: \"How are you?\" or \"You're really good at Minecraft.\" or \"CanI ask you something?",
                        1,false,null
                    ),
                    StepsforPractise(
                        "Comfortable with this",
                        " \"Once you're comfortable with this, try it next time with a family member or friend.\"",
                        1,false,null
                    ),
                    StepsforPractise(
                        "Comfortable with this",
                        " \"Once you're comfortable with this, try it next time with a family member or friend.\"",
                        5,false,null
                    ),

                    StepsforPractise(
                        "It may not be easy",
                        " It may not be easy, but now you've practiced you are prepared to start a conversation",
                        5,false,null
                    ),
                    StepsforPractise(
                        "Now is time to try with people",
                        " Maybe go back to the person who you wanted to talk to but you couldn't’t", 5,false,null
                    ),

                    ),
                R.raw.buildingconfidenc,
                5,null
            ),

            Goals(
                "Start Conversation",
                "learn how to start a conversations",
                listOf(
                    StepsforPractise(
                        "Start by practicing in the mirror",
                        "Start by practicing in the mirror. Can you think of a situation where you really wanted to talk to someone, but didn't?",
                        1,false,null
                    ),

                    StepsforPractise(
                        "Think about what you wanted to say",
                        "Start by practicing in the mirror. Can you think of a situation where you really wanted to talk to someone, but didn't?",
                        1,false,null
                    ),
                    StepsforPractise(
                        "Think about what you wanted to say",
                        " Think about what you wanted to say. How would you say hello?", 1,false,null
                    ),

                    StepsforPractise(
                        "What would you say next",
                        "What would you say next, for example: \"How are you?\" or \"You're really good at Minecraft.\" or \"CanI ask you something?",
                        1,false,null
                    ),

                    StepsforPractise(
                        "What would you say next",
                        "What would you say next, for example: \"How are you?\" or \"You're really good at Minecraft.\" or \"CanI ask you something?",
                        1,false,null
                    ),
                    StepsforPractise(
                        "Comfortable with this",
                        " \"Once you're comfortable with this, try it next time with a family member or friend.\"",
                        1,false,null
                    ),
                    StepsforPractise(
                        "Comfortable with this",
                        " \"Once you're comfortable with this, try it next time with a family member or friend.\"",
                        5,false,null
                    ),

                    StepsforPractise(
                        "It may not be easy",
                        " It may not be easy, but now you've practiced you are prepared to start a conversation",
                        5,false,null
                    ),
                    StepsforPractise(
                        "Now is time to try with people",
                        " Maybe go back to the person who you wanted to talk to but you couldn't’t", 5
                        ,false,null
                    ),

                    ),
                R.raw.buildingconfidenc,
                5,null
            ),
        )

        val goalListSelfGrow = listOf(
            Goals(
                "Talk Positive About Yourself",
                "Learn how to talk positive about yourself",
                listOf(
                    StepsforPractise(
                        "Think about what made you feel proud",
                        "Think about what made you feel proud.  It can be something you did or a personality trait you like about yourself",
                        1,false,null
                    ),
                    StepsforPractise(
                        "For example:'I am kind'",
                        "For example:'I am kind', 'I am good at drawing', 'I was very helpful in class yesterday' or 'I have great imagination",
                        1,false,null
                    ),
                    StepsforPractise(
                        "If this is difficult'",
                        "\"If this is difficult, consider what a friend or family member would  say about you\" ",
                        1,false,null
                    ),
                    StepsforPractise(
                        "\"Always remember It's important to value yourself",
                        " \"Always remember It's important to value yourself.  If this feels difficult to do, start with small things and continue practicing. It will get easier :)\"",
                        1,false,null
                    )
                ),
                R.raw.postivetalking,
                5,null
            ),
            Goals(
                "Talk Positive About Yourself",
                "Learn how to talk positive about yourself",
                listOf(
                    StepsforPractise(
                        "Think about what made you feel proud",
                        "Think about what made you feel proud.  It can be something you did or a personality trait you like about yourself",
                        1,false,null
                    ),
                    StepsforPractise(
                        "For example:'I am kind'",
                        "For example:'I am kind', 'I am good at drawing', 'I was very helpful in class yesterday' or 'I have great imagination",
                        1,false,null
                    ),
                    StepsforPractise(
                        "If this is difficult'",
                        "\"If this is difficult, consider what a friend or family member would  say about you\" ",
                        1,false,null
                    ),
                    StepsforPractise(
                        "\"Always remember It's important to value yourself",
                        " \"Always remember It's important to value yourself.  If this feels difficult to do, start with small things and continue practicing. It will get easier :)\"",
                        1,false,null
                    )
                ),
                R.raw.postivetalking,
                5,null
            ),
        )

        val goalListSelfDayToDay = listOf(
            Goals(
                "Brushing Your teeth",
                "Taking care of yourself Is part of your day to day exercise",
                listOf(
                    StepsforPractise(
                        "Best time to brush",
                        "the Best time to brush your teeth is in the morning",
                        1,false,null
                    ),
                    StepsforPractise(
                        "Pick your  favourite toothbrush",
                        "Pick your  favourite toothbrush. What’s your favourite colour?",
                        1,false,null
                    ),
                    StepsforPractise(
                        "Get your toothpaste",
                        "Pick your  favourite toothbrush. What’s your favourite colour?",
                        1,false,null
                    ),
                    StepsforPractise(
                        "Pick your  favourite toothbrush",
                        "\"Then  Get your toothpaste. What flavour  do you like Minty or Fruity?\"",
                        1,false,null
                    ),
                    StepsforPractise(
                        "Follow these steps",
                        " \"Now you have everything set up, follow these steps: \",",
                        1,false,null
                    ),
                    StepsforPractise(
                        "Brush the outside and inside",
                        "\"- Now you have everything set up, follow these steps: \"",
                        3,false,null
                    ),
                    StepsforPractise(
                        "Brush the top teeth",
                        "\"- Now you have everything set up, follow these steps: \"",
                        3,false,null
                    ),
                    StepsforPractise(
                        "Brush the  bottom teeth",
                        "Brush the outside and inside of your bottom teeth",
                        3,false,null
                    ),
                    StepsforPractise(
                        "Then brush your tongue",
                        "Then brush your tongue gently from top to bottom",
                        3,false,null
                    ),
                    StepsforPractise(
                        "Swish some water around your mouth",
                        "Once done, swish some water around your mouth and spit out the toothpaste  like this",
                        3,false,null
                    ),
                    StepsforPractise(
                        "As an extra  tip ",
                        "As an extra  tip Set a timer for 2 minutes to brush your teeth. \\n\" +\n" +
                                "\"If that feels very long, start with 1 minute and try to extend the timer by 10 sec. every time you brush!\"",
                        3,false,null
                    ),
                ),
                R.raw.brushingteeth,
                5,null
            ),
            Goals(
                "Think About future Jobs", "learn how to start to make a new friend",listOf(
                    StepsforPractise(
                        "Best time to brush",
                        "the Best time to brush your teeth is in the morning",
                        1,false,null
                    ),
                    StepsforPractise(
                        "Pick your  favourite toothbrush",
                        "Pick your  favourite toothbrush. What’s your favourite colour?",
                        1,false,null
                    ),
                    StepsforPractise(
                        "Get your toothpaste",
                        "Pick your  favourite toothbrush. What’s your favourite colour?",
                        1,false,null
                    ),
                    StepsforPractise(
                        "Pick your  favourite toothbrush",
                        "\"Then  Get your toothpaste. What flavour  do you like Minty or Fruity?\"",
                        1,false,null
                    ),
                    StepsforPractise(
                        "Follow these steps",
                        " \"Now you have everything set up, follow these steps: \",",
                        1,false,null
                    ),
                    StepsforPractise(
                        "Brush the outside and inside",
                        "\"- Now you have everything set up, follow these steps: \"",
                        3,false,null
                    ),
                    StepsforPractise(
                        "Brush the top teeth",
                        "\"- Now you have everything set up, follow these steps: \"",
                        3,false,null
                    ),
                    StepsforPractise(
                        "Brush the  bottom teeth",
                        "Brush the outside and inside of your bottom teeth",
                        3,false,null
                    ),
                    StepsforPractise(
                        "Then brush your tongue",
                        "Then brush your tongue gently from top to bottom",
                        3,false,null
                    ),
                    StepsforPractise(
                        "Swish some water around your mouth",
                        "Once done, swish some water around your mouth and spit out the toothpaste  like this",
                        3,false,null
                    ),
                    StepsforPractise(
                        "As an extra  tip ",
                        "As an extra  tip Set a timer for 2 minutes to brush your teeth. \\n\" +\n" +
                                "\"If that feels very long, start with 1 minute and try to extend the timer by 10 sec. every time you brush!\"",
                        3,false,null
                    ),
                ), R.raw.postivetalking, 5,null
            )
        )

        val excricesandgoalsList = listOf(
            Exercises("Communication", R.drawable.cummunication, goalListCommunication),
            Exercises("Social Situation", R.drawable.social_situation, goalListSocial),
            Exercises("Self Growth", R.drawable.self_growth, goalListSelfGrow),
            Exercises("Day to Day", R.drawable.day_to_day, goalListSelfDayToDay)
        )

        val recyclerview: RecyclerView = binding.recyclerviewExercisesAndGoals
        recyclerview.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val adapter = ExercisesAdapter(excricesandgoalsList, R.layout.excricesandgoals_list)
        recyclerview.adapter = adapter

        settingUpOnClickListenerForExcAdapter(adapter)

    }

    private fun settingUpOnClickListenerForExcAdapter(adapter: ExercisesAdapter) {

        adapter.setOnClickListener(object : ExercisesAdapter.OnClickListener {
            override fun onClick(position: Int, model: Exercises) {
                val intent = Intent(context, ExerciseslAcitvity::class.java)
                val exercises = Exercises(model.title, model.img, model.gaols)
                intent.putExtra("exercise", exercises)
                startActivity(intent)
            }
        })
    }


    private fun settingUpViewAndAspiration() {
        val viewAndAspirationList = listOf(
            ViewsAndAspirations("Health", R.drawable.health),
            ViewsAndAspirations("My future job", R.drawable.my_future_job),
            ViewsAndAspirations("My Independence", R.drawable.my_independency),
            ViewsAndAspirations("Confidence", R.drawable.confidence)
        )
        val recyclerview: RecyclerView = binding.recyclerviewViewsAndAspirations
        recyclerview.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val adapter =
            ViewAndAspirationAdapter(viewAndAspirationList, R.layout.views_and_aspirations_list)
        recyclerview.adapter = adapter
        settingUpOnClickListenerForViewsAdapter(adapter)
    }


    private fun settingUpOnClickListenerForViewsAdapter(adapter: ViewAndAspirationAdapter) {

        adapter.setOnClickListener(object : ViewAndAspirationAdapter.OnClickListener {
            override fun onClick(position: Int, model: ViewsAndAspirations) {
                val intent = Intent(context, ExerciseslAcitvity::class.java)
                startActivity(intent)
            }
        })
    }


}