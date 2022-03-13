package irubio.Algorithms;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.Arrays;
import java.util.Random;

@Route("")
public class MainView extends VerticalLayout {
    public MainView(){
        Button bubbleButton = new Button("Bubble Sort");
        Button insertButton = new Button("Insertion Sort");
        Button quickButton = new Button("Quick Sort");
        Button newArray = new Button("Generate New Array");

        add(newArray, bubbleButton,insertButton,quickButton);
        newArray.addClickListener(click -> {
            generateArray();
            add(new H1(Arrays.toString(generateArray())));
        });
        int[] inputArray = new int[10];











        System.out.println(inputArray);

    }

    public int bubbleSort(int[] input){
        return input[1];
    }

    public int[] generateArray(){
        int[] inputArray = new int[10];
        Random rd = new Random();
        for(int i=0; i<inputArray.length; i++){
            inputArray[i] = rd.nextInt(100);
        }
        return inputArray;
    }
}
