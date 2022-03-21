package irubio.Algorithms;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Random;


@Route("main")
@RequestMapping("/main")
@PageTitle("Algorithm Visualizer")
public class MainView extends VerticalLayout {

    VerticalLayout verticalLayout = new VerticalLayout ();
    HorizontalLayout horizontalLayout = new HorizontalLayout();
    int[] generated_array;

    public MainView(){
        verticalLayout.setAlignItems(Alignment.CENTER);
        Button newArray = new Button("Generate New Array");
        newArray.setSizeFull();
        newArray.addClickListener(click -> {
            generated_array = generateArray();
            printArray(generated_array);
        });

        Button bubbleButton = new Button("Bubble Sort");
        bubbleButton.addClickListener(click -> {
                bubbleSort();
        });

        Button insertButton = new Button("Insert Sort");
        insertButton.addClickListener(click ->{
           // clearLayout(horizontal);
        });




        HorizontalLayout algLayout = new HorizontalLayout();
        algLayout.add(bubbleButton,insertButton);



        add(newArray, algLayout, verticalLayout);
    }


    public void clearLayout(HorizontalLayout oldLayout){
        HorizontalLayout newLayout= new HorizontalLayout();
        oldLayout.removeAll();
        replace(oldLayout, newLayout);
    }



    public void bubbleSort(){
    //    printArray(generated_array);

        int[] sortedArray = generated_array.clone();
        // BUBBLE ALGORITHM START
        for(int lastUnsortedIndex = sortedArray.length-1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (sortedArray[i] > sortedArray[i + 1]) {
                    HorizontalLayout temp = new HorizontalLayout();
                    temp.add(new H2(String.valueOf(sortedArray[i])));
                    temp.add(new H2(">"));
                    temp.add(new H2(String.valueOf(sortedArray[i+1])));
                    verticalLayout.add(temp);

                    //printArray(sortedArray);
                 //   horizontalLayout.add(new H2(String.valueOf(sortedArray[i+1])));
                    swap(sortedArray, i, i + 1);

                  //  printArray(sortedArray);
                }
                verticalLayout.add(new H2(Arrays.toString(sortedArray)));
             //   verticalLayout.add(new H2(Arrays.toString(sortedArray)));
            }
            // BUBBLE ALGORITHM END

        }
    }

    public void printArray(int[] input){
        verticalLayout.removeAll();
        horizontalLayout.removeAll();
        for(int num: input){
            horizontalLayout.add(new H2(String.valueOf(num)));
        }
        verticalLayout.add(horizontalLayout);

    }


    public int[] insertSort(int[] input){
        return input;
    }


    public int[] generateArray(){
        int[] inputArray = new int[5];
        Random rd = new Random();
        for(int i=0; i<inputArray.length; i++){
            inputArray[i] = rd.nextInt(100);
        }
        return inputArray;
    }

    public static void swap(int[] array, int i, int j){
        if(i==j){
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

