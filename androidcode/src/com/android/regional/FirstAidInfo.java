package com.android.regional;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class FirstAidInfo extends Activity{
	TextView unconsciousness,heartattack;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstaid);
        
        unconsciousness=(TextView)findViewById(R.id.uncosciousness);
        heartattack=(TextView)findViewById(R.id.heartattack);
        
        //Set the information for first aid.
        unconsciousness.setText("Unconsciousness is when a person is unable to respond to people and activities. " +
        		                "Often, this is called a coma or being in a comatose state.\n\nConsiderations:-\n" +
        		                "1.Being asleep is not the same thing as being unconscious. A sleeping " +
        		                "person will respond to loud noises or gentle shaking -- an unconscious person " +
        		                "will not.\n2.An unconscious person cannot cough or clear his or her throat. This can " +
        		                "lead to death if the airway becomes blocked.\n\nCauses:-\n" +
        		                "1.Unconsciousness can be caused by nearly any major illness or " +
        		                "injury, as well as substance abuse and alcohol use.\n2.Brief " +
        		                "unconsciousness (or fainting) is often caused by dehydration, low blood sugar, " +
        		                "or temporary low blood pressure. However, it can also be caused by serious heart " +
        		                "or nervous system problems. Your doctor will determine if you need tests.\n3.Other " +
        		                "causes of fainting include straining during a bowel movement (vasovagal syncope), " +
        		                "coughing very hard, or breathing very fast (hyperventilating).\n\nSymtoms:-\n" +
        		                "1.The person will be unresponsive (does not respond to activity, touch, sound, or other stimulation)." +
        		                "\n2.The following symptoms may occur after a person has been unconscious:" +
        		                "\n3.Amnesia for events prior to, during, and even after the period of unconsciousness" +
        		                "\n4.Confusion\n5.Drowsiness\n6.Headache\n7.Inability to speak or move parts of his or her body" +
        		                "\n8.Lightheadness\n9.Loss of bowel or bladder control (incontinence)\n10.Rapid heartbeat (palpitations)" +
        		                "\n\nFirst Aid:-\n1.Check the person's airway, breathing, and pulse frequently. If necessary, begin rescue breathing and CPR." +
        		                "\n2.If the person is breathing and lying on the back, and you do not think there is a spinal injury, carefully " +
        		                "roll the person toward you onto the side. Bend the top leg so both hip and knee are at right angles. Gently tilt the head " +
        		                "back to keep the airway open. If breathing or pulse stops at any time, roll the person on to his back and begin CPR." +
        		                "\n3.If you think there is a spinal injury, leave the person where you found them (as long as breathing continues). " +
        		                "If the person vomits, roll the entire body at one time to the side. Support the neck and back to keep the head and body " +
        		                "in the same position while you roll." +
        		                "\n4.Keep the person warm until medical help arrives.\n5.If you see a person fainting, try to prevent a fall. Lay the person flat " +
        		                "on the floor and raise the feet about 12 inches." +
        		                "\n6.If fainting is likely due to low blood sugar, give the person something sweet to eat or drink when they become conscious.");
        
        heartattack.setText("A heart attack is a medical emergency.\nThe average person waits 3 hours before seeking help for symptoms of a heart attack. Many heart" +
        					"attack patients die before they reach a hospital. The sooner the person gets to the emergency room, the better the chance of survival. " +
        					"Prompt medical treatment reduces the amount of heart damage." +
        					"\n\nCauses:-\nA heart attack occurs when the blood flow that carries oxygen to the heart is blocked. The heart muscle becomes starved for " +
        					"oxygen and begins to die. \n\nSymtoms:-Symptoms of a heart attack can vary from person to person. They may be mild or severe. Women, the elderly, " +
        					"and people with diabetes are more likely to have subtle or unusual symptoms.\n\nSymptoms in adults may include:" +
        					"\n1.Changes in mental status, particularly in the elderly\n2.Chest pain that feels like pressure, squeezing, or fullness: The pain is usually in " +
        					"the center of the chest. It may also be felt in the jaw, shoulder, arms, back, and stomach. It lasts for more than a few minutes, or it may come and go." +
        					"\n3Cold sweat\n4.Light-headedness\n5.Nausea (more common in women)\n6.Numbness, aching, or tingling in the arm (usually the left arm)" +
        					"\n7.Shortness of breath\n8.Weakness or fatigue, particularly in the elderly\n\nFirst Aid:-" +
        					"\n1.Have the person sit down, rest, and try to keep calm.\n2.Loosen any tight clothing." +
        					"\n3.Ask if the person takes any chest pain medication for a known heart condition, such as nitroglycerin, " +
        					"and help them take it.\n4.If the pain does not go away promptly with rest or within 3 minutes of taking nitroglycerin, call for emergency " +
        					"medical help.\n5.If the person is unconscious and unresponsive, call 911 (or your local emergency number), then begin CPR." +
        					"\n6.If an infant or child is unconscious and unresponsive, perform 1 minute of CPR.");
        
        
	}
}
