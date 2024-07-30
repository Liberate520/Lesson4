package ru.zoo;

import java.util.List;

public class NoiseZoo {
    private List<Speakable> speakables;

    public NoiseZoo(List<Speakable> speakables) {
        this.speakables = speakables;
    }

    public void speakAll(){
        for (Speakable speakable: speakables){
            speakable.speak();
        }
    }
}
