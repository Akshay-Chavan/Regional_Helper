package com.android.regional;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class TouristInfo extends Activity{
	TextView dhammagiri,SaptashrungiGad,SaptashrungiDevi,saputara,bhandardara,veersavarkar,
	          coinmuseum,Gondeshwar,chambercaves,Naroshankar,SundarNarayan;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.touristinfo);
	        
	        dhammagiri=(TextView)findViewById(R.id.dhammagiri);
	        SaptashrungiGad=(TextView)findViewById(R.id.SaptashrungiGad);
	        SaptashrungiDevi=(TextView)findViewById(R.id.ShreeSaptashrungiDevi);
	        saputara=(TextView)findViewById(R.id.saputara);
	        bhandardara=(TextView)findViewById(R.id.bhandadara);
	        veersavarkar=(TextView)findViewById(R.id.veersavarkar);
	        coinmuseum=(TextView)findViewById(R.id.coinmuseum);
	        Gondeshwar=(TextView)findViewById(R.id.Gondeshwar);
	        chambercaves=(TextView)findViewById(R.id.chambercaves);
	        Naroshankar=(TextView)findViewById(R.id.Naroshankar);
	        SundarNarayan=(TextView)findViewById(R.id.ShreeSundarNarayan);
	        
	        //Set the information for tourist places.
	        dhammagiri.setText("Vipashyana International Academy is located at Igatpuri. " +
	        		"It was established in 1976 The aim was to conduct Vipassana Courses " +
	        		"for those in search of peace of mind and harmony. Known as Dhammagiri, " +
	        		"it is located in Igatpuri, 40 kms away from Nashik City, on Bombay-Agra road." +
	        		"This world famous meditation centre offers techniques which relieve mental " +
	        		"stress and promote inner peace. It is turning the wheel of time conversion " +
	        		"from Kalchakra to Dharmachakra under the able guidance of Guruji Satyanarayan " +
	        		"Goenka. A 10 day residential course at the centre, which is free of charge, " +
	        		"ends with Bhavatu Saba Mangalam meaning May all beings be happy.");
	        
	        SaptashrungiGad.setText("Shree Saptshrungi Gad is situated at a distance of 60 km " +
	        		"from Nashik.It is one of the most visited and religious places for pilgrims." +
	        		"As the temple is situated on a mountain, a regular bus service is provided from " +
	        		"the foot of the mountain to the temple");
	        
	        SaptashrungiDevi.setText("Saptashringa Garh is a place where Goddess Bhagawati dwells." +
	        		"It is one of the most important of the places of Goddesses in Maharashtra. " +
	        		"Saptashringa signifies seven mountain peaks. Nanduri village is situated at " +
	        		"the foot of the Saptashringa Gad. In front of the temple there stands " +
	        		"Markandeya Rishi's (sage) hill. The Saptashringa Gad is full of a variety of " +
	        		"trees having medicinal worth. As per the story depicted in Ramayana, " +
	        		"Hanuman carried the herbal medicine for wounded Laxmana from this hill. " +
	        		"There are about 108 water reservoirs on the hill, known as Kundas. " +
	        		"Vani is situated at a distance of 60 kms. away from Nashik");
	        
	        saputara.setText("This famous hill station equipped with adequate facilities is on " +
	        		"the border of Maharashtra & Gujrat State. Different hill points for sunrise & " +
	        		"a sunset makes this ideal tourist destination.");
	        
	        bhandardara.setText("Bhandardara 750 meters above the sea level surrounded by Deep " +
	        		"Valley, Large Dam, Great Lake, Roaring Water Falls, Historical Fort and an " +
	        		"Ancient Amruteshwar Temple is tourist paradise. Wilson Dam one of the very " +
	        		"few Dams constructed at such a height, encircled by a flock of Sahyadri hills " +
	        		"is Lake Arthur one of the largest in India. Randha Fall cascading down from 45 " +
	        		"meters is another gift of Mother Nature. The Amruteshwar Temple 9 Kms in the " +
	        		"interior of lake Arthur known for its beautiful carvings can be traced down " +
	        		"1200 years back in history and the Ratangad Fort is dear for mountaineering & " +
	        		"trekkers is one of the favorite Forts of the great historical legendry son of " +
	        		"soil Shree Chhatrapati Shivaji Maharaj (King).Overlooking Bhandardara is " +
	        		"Kalsubai highest peak of Maharashtra kissing the sky at 1646 meters. The " +
	        		"Konkankada at Ghatghar 22 Kms away measuring 361.79 Sq.Kms is another picnic " +
	        		"spot with panoramic view & declared as wild life sanctuary. The Average rain " +
	        		"fall is 3000 is a pleasant place to visit throughout the year. Ghatghar has " +
	        		"unique geographical identity as you can observe a Day of Ghatghar is only of " +
	        		"Four hours.");
	        
	        veersavarkar.setText("Bhagur is the birth place of the freedom fighter, Swatanrya Veer " +
	        		"Savarkar and hence it has gained historical importance. There is also a " +
	        		"beautiful temple of Bhagur Devi Bhagur is situated 3 km away from Deolali Camp " +
	        		"and 17 km from Nashik road.");
	        
	        coinmuseum.setText("The Indian Institute of Research in Numismatic Studies Established " +
	        		"in 1980 & located in the scenic surroundings of Anjneri Hill is one of its " +
	        		"kinds in Asia. Extensive archive of Indian Currency, photographs, articles, " +
	        		"line drawings, replicas & a well-documented researched history of Indian currency" +
	        		" that existed in India down the Centuries makes Coin Museum a place worth to " +
	        		"visit. The institute has also preserved One Lac cardexes for easy reference. " +
	        		"It has become the global destination for tourist for study & research. " +
	        		"The Institute undertakes workshops to promote coin collections in India. " +
	        		"K.J.Maheshwari Art Gallery has national & international award winning rare " +
	        		"photographs taken by Mr. K .J. Maheshwari.");
	        
	        Gondeshwar.setText("Unique Hemadpanthi style architectural temple located at Sinner " +
	        		"is the masterpiece of architecture. Historical & religious Gondeshwar temple " +
	        		"has Lord Shiva's idol & small temples around huge temple complex.");
	        
	        chambercaves.setText("Nashik City and the surrounding area is famous for many temples, " +
	        		"pilgrimage places etc. One of the sacred places for Jain Religion is Teerthraj " +
	        		"Gajpantha , which is at Mhasrul, 16 kms from Nashik Road Railway station and " +
	        		"5 kms from Nashik City. The famous CHAMBER CAVES are a part of this place. " +
	        		"It is situated on the top of a small hill which is only 400 ft tall. " +
	        		"The staircase, built in black stone leads to the temple and offers a " +
	        		"panoramic view. Although the nearby landscape is quite barren, some plantation " +
	        		"has been recently done. This is a very serene place, conducive for meditation." +
	        		" Gajapantha Teerth includes a caravanserai, a small hut the foot of the hill " +
	        		"and a temple at the top of the Gajadhwaja Hillock. As per the ancient holy " +
	        		"book Shantinath Purana Mysore’s Chamaraj King installed these statues " +
	        		"(600 B.C.) in the temple top the hill. Thus the caves got the name " +
	        		"Chamer Caves or Chambhar Caves in the regional language.");
	        
	        Naroshankar.setText("Situated in Panchavati area about 2km from Central Bus Stand, on " +
	        		"the bank of river Godavari - fondly called as ganga by Nasikites - is " +
	        		"Naroshankar Temple of Rameshwar built by Naroshankar Rajebahaddur in 1747. " +
	        		"The architectural style of the temple is called Maya. It is one of the most " +
	        		"beautiful pieces of architecture of the 18th century. Sculpture on the" +
	        		" outer side of the temple is stunning. It has rows of exuberant designs." +
	        		" One layer is of decorative lacework. The next one is that of peacocks " +
	        		"holding bead garlands. In four directions are statues of the saints in" +
	        		" Padmasana. There is also an assembly of animals - tigers, monkeys," +
	        		"elephants etc. This depicts that Hindu culture is not limited only to human " +
	        		"beings but also has relation with birds, animals, trees, and nature in general." +
	        		" In its four corners are umbrellas - called Meghadambari or Barasati." +
	        		" One of them was washed away in Godavari floods and only three are existing " +
	        		"presently. The surrounding fortification centres a Bell house in the front " +
	        		"part. The famous bell , called Naroshankar Bell is fixed here. " +
	        		"The bell is a victory memorial over Portuguese.");
	        
	        SundarNarayan.setText("The Sundarnarayan temple is built by Gangadhar Yashwant " +
	        		"Chandrachud in 1756 at a distance of 1 km from Central Bus Stand. The " +
	        		"entrance of the temple is to the East. The architecture is attractive and " +
	        		"the round dome is made by little ornamental cordons. The arched recesses " +
	        		"are impressions of Mughal sclupture. The main deity is of Lord Vishnu - " +
	        		"also called Narayana. To the left and right are Laxmi and Saraswati " +
	        		"respectively. Fine design is carved on the stones of the temple. On the " +
	        		"road leading towards Godavari River there is Badarika Sangam Pond. It is " +
	        		"said that the king of Devgiri bathed and performed rites in this pond. We " +
	        		"also find a mention of this pond in the holy book Dnyaneshwari. One " +
	        		"remarkable thing about this temple is that it is built at such an angle " +
	        		"that on 21st March, rays of the rising Sun first fall exactly upon the idols.");
	 }
}
