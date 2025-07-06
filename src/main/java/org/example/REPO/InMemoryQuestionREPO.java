package org.example.REPO;

import org.example.Entity.Choice;
import org.example.Entity.Question;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryQuestionREPO implements QuestionREPO {

    private final Map<String, Question> questions = new HashMap<>();

    public InMemoryQuestionREPO() {


        questions.put("q1", new Question("q1", "You awaken in a damp, stone chamber with moss-covered walls. A faint humming echoes around you. A single torch flickers nearby.",
                List.of(
                        new Choice("A", "Pick up the torch", "q21"),
                        new Choice("B", "Listen closely to the humming", "q14"),
                        new Choice("C", "Open the rusted door", "q5"),
                        new Choice("D", "Knock on the wall", "death_1")
                ), false, false));

        questions.put("q2", new Question("q2", "A hallway stretches before you, its floor lined with carved runes. A pedestal stands at the center with a glowing orb.",
                List.of(
                        new Choice("A", "Touch the orb", "q33"),
                        new Choice("B", "Inspect the runes", "q17"),
                        new Choice("C", "Walk around the pedestal", "q27"),
                        new Choice("D", "Kick the orb", "death_2")
                ), false, false));

        questions.put("q3", new Question("q3", "You find a dusty library with books written in shifting script. One tome lies open, glowing faintly.",
                List.of(
                        new Choice("A", "Read it aloud", "death_3"),
                        new Choice("B", "Flip to the last page", "q45"),
                        new Choice("C", "Close the book", "q12"),
                        new Choice("D", "Copy a rune into your palm", "q55")
                ), false, false));

        questions.put("q4", new Question("q4", "A quiet room filled with broken mirrors. Your reflection doesn’t match your movements.",
                List.of(
                        new Choice("A", "Smash the mirror", "q42"),
                        new Choice("B", "Touch your reflection", "death_4"),
                        new Choice("C", "Sit and observe", "q31"),
                        new Choice("D", "Whisper to the reflection", "q19")
                ), false, false));

        questions.put("q5", new Question("q5", "A hallway leads to three doors: one wooden, one metal, one stone. A keyring hangs nearby.",
                List.of(
                        new Choice("A", "Take the keyring", "q9"),
                        new Choice("B", "Open the wooden door", "q18"),
                        new Choice("C", "Open the metal door", "death_5"),
                        new Choice("D", "Knock on the stone door", "q34")
                ), false, false));

        questions.put("q6", new Question("q6", "You enter a chamber where a painting of a crying woman hangs on the wall. Her tears shimmer.",
                List.of(
                        new Choice("A", "Wipe her tears", "q36"),
                        new Choice("B", "Step back quietly", "q7"),
                        new Choice("C", "Touch the frame", "death_6"),
                        new Choice("D", "Say her name (if you know it)", "q59")
                ), false, false));

        questions.put("q7", new Question("q7", "A spiral staircase leads down into a dark chasm. The air smells of iron and moss.",
                List.of(
                        new Choice("A", "Descend slowly", "q26"),
                        new Choice("B", "Throw a stone below", "q15"),
                        new Choice("C", "Call out", "death_7"),
                        new Choice("D", "Look for another path", "q60")
                ), false, false));

        questions.put("q8", new Question("q8", "You step into a flooded corridor. Something brushes past your leg.",
                List.of(
                        new Choice("A", "Run forward", "q11"),
                        new Choice("B", "Dive under the water", "q43"),
                        new Choice("C", "Stay still and wait", "q30"),
                        new Choice("D", "Reach for the thing", "death_8")
                ), false, false));

        questions.put("q9", new Question("q9", "You examine the keyring. Each key glows differently — red, green, blue, black.",
                List.of(
                        new Choice("A", "Use red key", "death_9"),
                        new Choice("B", "Use green key", "q58"),
                        new Choice("C", "Use blue key", "q23"),
                        new Choice("D", "Use black key", "q39")
                ), false, false));

        questions.put("q10", new Question("q10", "A skeletal hand rises from the ground, holding a scroll.",
                List.of(
                        new Choice("A", "Take the scroll", "q13"),
                        new Choice("B", "Step back", "q41"),
                        new Choice("C", "Say 'Thank you'", "q20"),
                        new Choice("D", "Smash the hand", "death_10")
                ), false, false));
        questions.put("q11", new Question("q11",
                "You sprint through the flooded corridor and find a dry exit leading to a collapsed bridge.",
                List.of(
                        new Choice("A", "Try to jump across the bridge", "death_11"),
                        new Choice("B", "Look for a way around", "q22"),
                        new Choice("C", "Call for help", "death_12"),
                        new Choice("D", "Turn back", "q8")
                ), false, false));

        questions.put("q12", new Question("q12",
                "You close the glowing tome and hear a faint whisper guiding you to a hidden passage.",
                List.of(
                        new Choice("A", "Follow the whisper", "q28"),
                        new Choice("B", "Ignore it and explore the room", "q35"),
                        new Choice("C", "Try to block out the whisper", "death_13"),
                        new Choice("D", "Read the tome again carefully", "q3")
                ), false, false));

        questions.put("q13", new Question("q13",
                "The scroll contains an incantation. Reading it aloud causes the room to shake.",
                List.of(
                        new Choice("A", "Continue chanting", "death_14"),
                        new Choice("B", "Stop immediately", "q16"),
                        new Choice("C", "Throw the scroll away", "q40"),
                        new Choice("D", "Examine the room quickly", "q37")
                ), false, false));

        questions.put("q14", new Question("q14",
                "Listening closely, you identify the humming as the sound of enchanted chains.",
                List.of(
                        new Choice("A", "Search for the source", "q25"),
                        new Choice("B", "Ignore and move on", "q38"),
                        new Choice("C", "Try to break the chains", "death_15"),
                        new Choice("D", "Cover your ears", "q32")
                ), false, false));

        questions.put("q15", new Question("q15",
                "You toss a stone down the spiral stairwell; it clatters noisily then silence.",
                List.of(
                        new Choice("A", "Descend carefully", "q7"),
                        new Choice("B", "Wait for a response", "death_7"),
                        new Choice("C", "Throw another stone", "q56"),
                        new Choice("D", "Go back", "q1")
                ), false, false));

        questions.put("q16", new Question("q16",
                "Stopping the chant, the room calms and a door slowly opens revealing a new path.",
                List.of(
                        new Choice("A", "Enter the door", "q44"),
                        new Choice("B", "Close the door", "q13"),
                        new Choice("C", "Call out to see if anyone is inside", "death_10"),
                        new Choice("D", "Look for traps", "q50")
                ), false, false));

        questions.put("q17", new Question("q17",
                "The runes pulse as you study them, revealing a sequence you must repeat.",
                List.of(
                        new Choice("A", "Mimic the sequence", "q24"),
                        new Choice("B", "Ignore the runes", "death_2"),
                        new Choice("C", "Attempt to erase the runes", "death_5"),
                        new Choice("D", "Take a rubbing of the runes", "q29")
                ), false, false));

        questions.put("q18", new Question("q18",
                "The wooden door creaks open to a small room with an ornate chest.",
                List.of(
                        new Choice("A", "Open the chest", "q54"),
                        new Choice("B", "Inspect the room for traps", "q49"),
                        new Choice("C", "Leave the chest alone", "q5"),
                        new Choice("D", "Sit and rest", "death_8")
                ), false, false));

        questions.put("q19", new Question("q19",
                "Whispering to your reflection, it smiles and points to a hidden lever.",
                List.of(
                        new Choice("A", "Pull the lever", "q53"),
                        new Choice("B", "Ignore and move on", "q31"),
                        new Choice("C", "Break the mirror", "death_4"),
                        new Choice("D", "Try to communicate more", "q42")
                ), false, false));

        questions.put("q20", new Question("q20",
                "Your polite thanks seem to please the skeletal hand, which drops the scroll.",
                List.of(
                        new Choice("A", "Take the scroll", "q13"),
                        new Choice("B", "Look around the room", "q41"),
                        new Choice("C", "Attempt to read the scroll silently", "death_14"),
                        new Choice("D", "Leave quietly", "q50")
                ), false, false));
        questions.put("q21", new Question("q21",
                "You grip the torch, its light flickering wildly, casting shadows on the damp walls.",
                List.of(
                        new Choice("A", "Walk deeper into the chamber", "q44"),
                        new Choice("B", "Wave the torch to scare creatures", "q39"),
                        new Choice("C", "Examine the walls for markings", "q35"),
                        new Choice("D", "Extinguish the torch", "death_12")
                ), false, false));

        questions.put("q22", new Question("q22",
                "Searching around, you find a narrow tunnel leading further into darkness.",
                List.of(
                        new Choice("A", "Enter the tunnel", "q50"),
                        new Choice("B", "Go back to the flooded corridor", "q8"),
                        new Choice("C", "Mark the path with chalk", "q37"),
                        new Choice("D", "Shout to see if anyone is nearby", "death_7")
                ), false, false));

        questions.put("q23", new Question("q23",
                "The blue key fits perfectly in a small door revealing a room filled with ancient relics.",
                List.of(
                        new Choice("A", "Take a relic", "death_15"),
                        new Choice("B", "Inspect the relics carefully", "q56"),
                        new Choice("C", "Search for hidden compartments", "q60"),
                        new Choice("D", "Leave the room", "q9")
                ), false, false));

        questions.put("q24", new Question("q24",
                "You mimic the rune sequence, and a secret passage opens beside the pedestal.",
                List.of(
                        new Choice("A", "Enter the passage", "q61"),
                        new Choice("B", "Stay near the pedestal", "death_2"),
                        new Choice("C", "Examine the pedestal closely", "q17"),
                        new Choice("D", "Step back", "q22")
                ), false, false));

        questions.put("q25", new Question("q25",
                "You find heavy chains binding a sleeping beast, its breath shallow and slow.",
                List.of(
                        new Choice("A", "Attempt to free the beast", "death_16"),
                        new Choice("B", "Sneak past quietly", "q52"),
                        new Choice("C", "Search for keys to the chains", "q55"),
                        new Choice("D", "Retreat silently", "q14")
                ), false, false));

        questions.put("q26", new Question("q26",
                "You carefully descend the spiral staircase, the sound of dripping water growing louder.",
                List.of(
                        new Choice("A", "Continue descending", "q48"),
                        new Choice("B", "Listen for sounds", "q30"),
                        new Choice("C", "Go back up", "q7"),
                        new Choice("D", "Throw a rock to test the path", "death_11")
                ), false, false));

        questions.put("q27", new Question("q27",
                "Walking around the pedestal, you notice faint footsteps leading to a hidden door.",
                List.of(
                        new Choice("A", "Follow the footsteps", "q51"),
                        new Choice("B", "Inspect the hidden door", "q63"),
                        new Choice("C", "Return to the pedestal", "q2"),
                        new Choice("D", "Ignore and move on", "death_7")
                ), false, false));

        questions.put("q28", new Question("q28",
                "Following the whisper, you find a small alcove with a glowing amulet.",
                List.of(
                        new Choice("A", "Take the amulet", "q64"),
                        new Choice("B", "Leave it alone", "q12"),
                        new Choice("C", "Wear the amulet", "death_17"),
                        new Choice("D", "Examine the alcove for traps", "q55")
                ), false, false));

        questions.put("q29", new Question("q29",
                "The rune rubbing reveals a map of the dungeon’s deeper chambers.",
                List.of(
                        new Choice("A", "Follow the map", "q67"),
                        new Choice("B", "Ignore the map", "q17"),
                        new Choice("C", "Destroy the rubbing", "death_5"),
                        new Choice("D", "Show the rubbing to a nearby statue", "q34")
                ), false, false));

        questions.put("q30", new Question("q30",
                "You wait silently as the corridor water stills, revealing faint glowing shapes beneath the surface.",
                List.of(
                        new Choice("A", "Reach into the water", "death_8"),
                        new Choice("B", "Try to catch one", "q43"),
                        new Choice("C", "Move on carefully", "q48"),
                        new Choice("D", "Call out to the shapes", "death_7")
                ), false, false));

        questions.put("q31", new Question("q31",
                "Sitting to observe your reflection, it suddenly gestures to a nearby loose stone.",
                List.of(
                        new Choice("A", "Pull the stone", "q53"),
                        new Choice("B", "Ignore the gesture", "q4"),
                        new Choice("C", "Try to mimic the gesture", "death_4"),
                        new Choice("D", "Call out to your reflection", "q19")
                ), false, false));

        questions.put("q32", new Question("q32",
                "Covering your ears, the humming fades but the chains rattle louder.",
                List.of(
                        new Choice("A", "Search for the source of chains", "q25"),
                        new Choice("B", "Remove your hands", "q14"),
                        new Choice("C", "Call out in frustration", "death_7"),
                        new Choice("D", "Run away", "q39")
                ), false, false));

        questions.put("q33", new Question("q33",
                "Touching the orb, you feel a surge of energy as visions flood your mind.",
                List.of(
                        new Choice("A", "Focus on the visions", "q42"),
                        new Choice("B", "Pull your hand back quickly", "q2"),
                        new Choice("C", "Try to control the energy", "death_13"),
                        new Choice("D", "Squeeze the orb tightly", "death_2")
                ), false, false));

        questions.put("q34", new Question("q34",
                "Knocking on the stone door, it slowly opens revealing a chamber filled with glowing mushrooms.",
                List.of(
                        new Choice("A", "Step inside carefully", "q58"),
                        new Choice("B", "Pick a glowing mushroom", "death_18"),
                        new Choice("C", "Smell the air", "q36"),
                        new Choice("D", "Close the door quietly", "q5")
                ), false, false));

        questions.put("q35", new Question("q35",
                "Exploring the room, you find strange symbols etched into the floor.",
                List.of(
                        new Choice("A", "Trace the symbols with your finger", "q24"),
                        new Choice("B", "Avoid touching them", "q12"),
                        new Choice("C", "Attempt to copy the symbols", "death_3"),
                        new Choice("D", "Step back and observe", "q31")
                ), false, false));

        questions.put("q36", new Question("q36",
                "Wiping the painting’s tears reveals a hidden message beneath the layers of dust.",
                List.of(
                        new Choice("A", "Read the message aloud", "q48"),
                        new Choice("B", "Take a rubbing of the message", "q29"),
                        new Choice("C", "Touch the painting’s frame", "death_6"),
                        new Choice("D", "Step back cautiously", "q7")
                ), false, false));

        questions.put("q37", new Question("q37",
                "Examining the room quickly, you notice faint footprints leading to a trapdoor.",
                List.of(
                        new Choice("A", "Open the trapdoor", "q49"),
                        new Choice("B", "Follow the footprints", "q52"),
                        new Choice("C", "Ignore the trapdoor", "q35"),
                        new Choice("D", "Prepare for an ambush", "death_8")
                ), false, false));

        questions.put("q38", new Question("q38",
                "You move on, but a sudden chill runs down your spine as shadows flicker nearby.",
                List.of(
                        new Choice("A", "Investigate the shadows", "death_4"),
                        new Choice("B", "Hurry forward", "q41"),
                        new Choice("C", "Prepare your weapon", "q53"),
                        new Choice("D", "Hide quietly", "q60")
                ), false, false));

        questions.put("q39", new Question("q39",
                "As you proceed, unseen eyes watch your every step, the air thick with tension.",
                List.of(
                        new Choice("A", "Call out to whoever watches", "death_7"),
                        new Choice("B", "Move stealthily", "q52"),
                        new Choice("C", "Set a trap for your pursuer", "q56"),
                        new Choice("D", "Find a hiding spot", "q55")
                ), false, false));

        questions.put("q40", new Question("q40",
                "You throw the scroll away, hearing it land softly in an empty chamber.",
                List.of(
                        new Choice("A", "Search for the scroll", "death_3"),
                        new Choice("B", "Keep moving forward", "q41"),
                        new Choice("C", "Listen carefully", "q14"),
                        new Choice("D", "Return to the skeletal hand", "q10")
                ), false, false));
        questions.put("q41", new Question("q41",
                "You find yourself in a chamber filled with ancient statues, their eyes seeming to follow you.",
                List.of(
                        new Choice("A", "Inspect the statues closely", "q53"),
                        new Choice("B", "Try to move past quickly", "death_5"),
                        new Choice("C", "Call out to the statues", "death_7"),
                        new Choice("D", "Look for hidden switches", "q49")
                ), false, false));

        questions.put("q42", new Question("q42",
                "After smashing the mirror, a hidden doorway opens behind the shards.",
                List.of(
                        new Choice("A", "Enter the doorway", "q60"),
                        new Choice("B", "Collect a shard", "death_6"),
                        new Choice("C", "Shout to test the room", "death_7"),
                        new Choice("D", "Leave the room", "q4")
                ), false, false));

        questions.put("q43", new Question("q43",
                "Diving under water, you discover a submerged tunnel illuminated by glowing crystals.",
                List.of(
                        new Choice("A", "Swim through the tunnel", "q48"),
                        new Choice("B", "Surface and rest", "q30"),
                        new Choice("C", "Collect a glowing crystal", "death_15"),
                        new Choice("D", "Go back", "q8")
                ), false, false));

        questions.put("q44", new Question("q44",
                "You enter the newly opened door to find a room with an altar and a shining sword.",
                List.of(
                        new Choice("A", "Take the sword", "q66"),
                        new Choice("B", "Inspect the altar", "q54"),
                        new Choice("C", "Leave the room quietly", "q21"),
                        new Choice("D", "Attempt to pray", "death_16")
                ), false, false));

        questions.put("q45", new Question("q45",
                "Flipping to the last page, you see a cryptic warning about the dungeon’s curse.",
                List.of(
                        new Choice("A", "Heed the warning", "q28"),
                        new Choice("B", "Ignore it", "death_3"),
                        new Choice("C", "Search for a way to break the curse", "q37"),
                        new Choice("D", "Burn the book", "death_5")
                ), false, false));

        questions.put("q46", new Question("q46",
                "You find a dusty journal detailing past explorers’ fates.",
                List.of(
                        new Choice("A", "Read it thoroughly", "q56"),
                        new Choice("B", "Look for clues in the journal", "q29"),
                        new Choice("C", "Discard it", "q1"),
                        new Choice("D", "Take the journal with you", "q67")
                ), false, false));

        questions.put("q47", new Question("q47",
                "A narrow ledge leads to a balcony overlooking a vast underground lake.",
                List.of(
                        new Choice("A", "Cross the ledge", "death_11"),
                        new Choice("B", "Find a safer path", "q50"),
                        new Choice("C", "Jump into the lake", "death_8"),
                        new Choice("D", "Look for boats", "q62")
                ), false, false));

        questions.put("q48", new Question("q48",
                "You reach the bottom of the stairwell to find a cavern lit by bioluminescent fungi.",
                List.of(
                        new Choice("A", "Explore the cavern", "q64"),
                        new Choice("B", "Rest near the fungi", "death_8"),
                        new Choice("C", "Gather some fungi", "q39"),
                        new Choice("D", "Search for exits", "q70")
                ), false, false));

        questions.put("q49", new Question("q49",
                "Investigating the trapdoor, you hear a low growl from below.",
                List.of(
                        new Choice("A", "Open the trapdoor", "death_16"),
                        new Choice("B", "Throw a rope down", "q52"),
                        new Choice("C", "Close the trapdoor and retreat", "q41"),
                        new Choice("D", "Call out to whatever’s below", "death_7")
                ), false, false));

        questions.put("q50", new Question("q50",
                "You find a narrow path winding around the dungeon’s perimeter.",
                List.of(
                        new Choice("A", "Follow the path", "q67"),
                        new Choice("B", "Go back", "q16"),
                        new Choice("C", "Set a trap on the path", "q56"),
                        new Choice("D", "Rest here", "death_8")
                ), false, false));

        questions.put("q51", new Question("q51",
                "Following the footprints leads you to a room filled with flickering candles and a strange altar.",
                List.of(
                        new Choice("A", "Approach the altar", "q66"),
                        new Choice("B", "Extinguish the candles", "death_13"),
                        new Choice("C", "Search the room", "q61"),
                        new Choice("D", "Leave quickly", "q27")
                ), false, false));

        questions.put("q52", new Question("q52",
                "You sneak past the sleeping beast and enter a chamber filled with gold coins.",
                List.of(
                        new Choice("A", "Take some gold", "death_9"),
                        new Choice("B", "Look for an exit", "q70"),
                        new Choice("C", "Set a trap", "q56"),
                        new Choice("D", "Sit and rest", "death_8")
                ), false, false));

        questions.put("q53", new Question("q53",
                "Pulling the lever, a section of the wall slides open revealing a hidden staircase.",
                List.of(
                        new Choice("A", "Descend the staircase", "q26"),
                        new Choice("B", "Ignore and move on", "q41"),
                        new Choice("C", "Close the secret door", "q31"),
                        new Choice("D", "Prepare for ambush", "death_7")
                ), false, false));

        questions.put("q54", new Question("q54",
                "Opening the ornate chest reveals a beautifully crafted amulet glowing softly.",
                List.of(
                        new Choice("A", "Take the amulet", "q64"),
                        new Choice("B", "Leave it alone", "q18"),
                        new Choice("C", "Wear the amulet", "death_17"),
                        new Choice("D", "Inspect the chest for traps", "q49")
                ), false, false));

        questions.put("q55", new Question("q55",
                "You find a hidden compartment containing strange, glowing runes.",
                List.of(
                        new Choice("A", "Touch the runes", "death_13"),
                        new Choice("B", "Copy the runes", "q24"),
                        new Choice("C", "Ignore them", "q37"),
                        new Choice("D", "Take the runes with you", "q29")
                ), false, false));

        questions.put("q56", new Question("q56",
                "You set a trap using materials around you, hoping to catch any pursuers.",
                List.of(
                        new Choice("A", "Wait quietly", "q39"),
                        new Choice("B", "Leave the area", "q70"),
                        new Choice("C", "Check the trap", "death_15"),
                        new Choice("D", "Hide nearby", "q52")
                ), false, false));

        questions.put("q57", new Question("q57",
                "You find a strange portal swirling with mist and shadows.",
                List.of(
                        new Choice("A", "Enter the portal", "end"),
                        new Choice("B", "Touch the portal’s edge", "death_18"),
                        new Choice("C", "Back away slowly", "q60"),
                        new Choice("D", "Shout through the portal", "death_7")
                ), false, false));

        questions.put("q58", new Question("q58",
                "Inside the mushroom chamber, the spores fill the air with a hypnotic scent.",
                List.of(
                        new Choice("A", "Breathe deeply", "death_8"),
                        new Choice("B", "Collect some spores", "q64"),
                        new Choice("C", "Move cautiously", "q34"),
                        new Choice("D", "Exit the chamber", "q5")
                ), false, false));

        questions.put("q59", new Question("q59",
                "Saying the woman’s name aloud causes the painting to shimmer and reveal a hidden passage.",
                List.of(
                        new Choice("A", "Enter the passage", "q66"),
                        new Choice("B", "Step back cautiously", "q7"),
                        new Choice("C", "Touch the painting", "death_6"),
                        new Choice("D", "Ignore the passage", "q36")
                ), false, false));

        questions.put("q60", new Question("q60",
                "You find another path branching deep underground, its walls etched with glowing symbols.",
                List.of(
                        new Choice("A", "Follow the symbols", "q67"),
                        new Choice("B", "Turn back", "q7"),
                        new Choice("C", "Attempt to decipher the symbols", "q24"),
                        new Choice("D", "Ignore the symbols", "death_3")
                ), false, false));

        questions.put("q61", new Question("q61",
                "The secret passage opens into a chamber with a pedestal holding a glowing crystal.",
                List.of(
                        new Choice("A", "Take the crystal", "q64"),
                        new Choice("B", "Examine the pedestal", "q24"),
                        new Choice("C", "Leave it alone", "q51"),
                        new Choice("D", "Destroy the pedestal", "death_5")
                ), false, false));

        questions.put("q62", new Question("q62",
                "Finding an old boat, you prepare to cross the underground lake.",
                List.of(
                        new Choice("A", "Row across", "q70"),
                        new Choice("B", "Search the boat for supplies", "q56"),
                        new Choice("C", "Look for another crossing", "q47"),
                        new Choice("D", "Jump into the water", "death_8")
                ), false, false));

        questions.put("q63", new Question("q63",
                "Inspecting the hidden door, you notice faint scratch marks around the handle.",
                List.of(
                        new Choice("A", "Open the door slowly", "q57"),
                        new Choice("B", "Leave it alone", "q27"),
                        new Choice("C", "Try to pick the lock", "death_9"),
                        new Choice("D", "Knock softly", "death_7")
                ), false, false));

        questions.put("q64", new Question("q64",
                "Taking the glowing amulet, you feel a warmth spread through your body.",
                List.of(
                        new Choice("A", "Wear the amulet", "q66"),
                        new Choice("B", "Put it in your bag", "q29"),
                        new Choice("C", "Discard it", "q28"),
                        new Choice("D", "Examine it closely", "q55")
                ), false, false));

        questions.put("q65", new Question("q65",
                "You discover a locked chest that hums with magical energy.",
                List.of(
                        new Choice("A", "Attempt to open the chest", "death_2"),
                        new Choice("B", "Search for the key", "q9"),
                        new Choice("C", "Leave it alone", "q18"),
                        new Choice("D", "Inspect for traps", "q49")
                ), false, false));

        questions.put("q66", new Question("q66",
                "The sword on the altar pulses with power, humming softly in your hand.",
                List.of(
                        new Choice("A", "Take the sword", "end"),
                        new Choice("B", "Leave it", "q44"),
                        new Choice("C", "Swing the sword experimentally", "death_14"),
                        new Choice("D", "Examine the altar further", "q54")
                ), false, false));

        questions.put("q67", new Question("q67",
                "Following the map, you find a hidden chamber filled with glowing runes and a large door.",
                List.of(
                        new Choice("A", "Open the large door", "end"),
                        new Choice("B", "Study the runes", "q24"),
                        new Choice("C", "Search for traps", "q49"),
                        new Choice("D", "Turn back", "q50")
                ), false, false));

        questions.put("q68", new Question("q68",
                "You find a small shrine dedicated to forgotten gods.",
                List.of(
                        new Choice("A", "Offer a prayer", "q66"),
                        new Choice("B", "Take an offering", "death_9"),
                        new Choice("C", "Leave quietly", "q50"),
                        new Choice("D", "Search the shrine", "q29")
                ), false, false));

        questions.put("q69", new Question("q69",
                "A narrow bridge spans a deep chasm filled with swirling mist.",
                List.of(
                        new Choice("A", "Cross the bridge", "q70"),
                        new Choice("B", "Look for another way around", "q50"),
                        new Choice("C", "Throw a rock to test the bridge", "death_11"),
                        new Choice("D", "Turn back", "q7")
                ), false, false));

        questions.put("q70", new Question("q70",
                "You find a heavy iron door with strange runes etched around the edges.",
                List.of(
                        new Choice("A", "Push the door open", "end"),
                        new Choice("B", "Knock on the door", "death_7"),
                        new Choice("C", "Inspect the runes", "q24"),
                        new Choice("D", "Step back and observe", "q48")
                ), false, false));
        questions.put("death_1", new Question("death_1",
                "The wall crumbles as you knock, burying you beneath rubble. Your adventure ends here.",
                List.of(), true, false));

        questions.put("death_2", new Question("death_2",
                "The orb explodes violently as you kick it, flames engulfing you instantly.",
                List.of(), true, false));

        questions.put("death_3", new Question("death_3",
                "Reading the forbidden tome aloud summons an otherworldly horror that devours you.",
                List.of(), true, false));

        questions.put("death_4", new Question("death_4",
                "Your reflection reaches out and pulls you into the mirror’s dark realm. You vanish forever.",
                List.of(), true, false));

        questions.put("death_5", new Question("death_5",
                "A fiery blast erupts from the metal door as you open it, incinerating you instantly.",
                List.of(), true, false));

        questions.put("death_6", new Question("death_6",
                "Touching the frame triggers hidden blades slicing your hand clean off.",
                List.of(), true, false));

        questions.put("death_7", new Question("death_7",
                "Something answers your call, and darkness envelops you before you can react.",
                List.of(), true, false));

        questions.put("death_8", new Question("death_8",
                "Reaching for the unseen creature under water, it drags you down to a watery grave.",
                List.of(), true, false));

        questions.put("death_9", new Question("death_9",
                "The red key melts in your hand, burning you with searing heat before you drop dead.",
                List.of(), true, false));

        questions.put("death_10", new Question("death_10",
                "The skeletal hand crushes your arm as you attempt to smash it, ending your journey.",
                List.of(), true, false));

        questions.put("death_11", new Question("death_11",
                "You step onto the narrow ledge but lose your footing. The ground gives way beneath you and you fall into the abyss below. Darkness swallows you whole.\n\nGAME OVER.",
                List.of(), true, true));

        questions.put("death_12", new Question("death_12",
                "Extinguishing the torch plunges you into complete darkness. Suddenly, unseen creatures swarm and overwhelm you.\n\nGAME OVER.",
                List.of(), true, true));

        questions.put("death_13", new Question("death_13",
                "Touching the glowing runes releases a burst of arcane energy that burns your flesh and shatters your mind.\n\nGAME OVER.",
                List.of(), true, true));

        questions.put("death_14", new Question("death_14",
                "Swinging the enchanted sword carelessly triggers a magical backlash, electrocuting you instantly.\n\nGAME OVER.",
                List.of(), true, true));

        questions.put("death_15", new Question("death_15",
                "Reaching for the glowing crystal, it explodes in a blinding flash, vaporizing everything nearby.\n\nGAME OVER.",
                List.of(), true, true));

        questions.put("death_16", new Question("death_16",
                "Attempting to free the chained beast awakens it. With a roar, it lunges and crushes you mercilessly.\n\nGAME OVER.",
                List.of(), true, true));

        questions.put("death_17", new Question("death_17",
                "Wearing the amulet curses you, twisting your body into an unrecognizable form.\n\nGAME OVER.",
                List.of(), true, true));

        questions.put("death_18", new Question("death_18",
                "Picking a glowing mushroom releases toxic spores. You gasp for air as the poison takes hold.\n\nGAME OVER.",
                List.of(), true, true));
        questions.put("end", new Question("end",
                "You find the exit and step into the daylight, your adventure complete.",
                List.of(), false, true));
    }
    @Override
    public Optional<Question> findById(String id) {
        return Optional.ofNullable(questions.get(id));
    }}