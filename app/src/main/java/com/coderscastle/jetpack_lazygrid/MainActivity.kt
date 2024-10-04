package com.coderscastle.jetpack_lazygrid

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.coderscastle.jetpack_lazygrid.ui.theme.JetpackLazyGridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackLazyGridTheme {

                LazyVerticalGrid(

                    columns = GridCells.Fixed(2),
                    content = {
                       items(getCardData().size) {index->
                           CardDesign(getCardData()[index])
                       }
                    },
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.padding(top = 50.dp, start = 10.dp, end = 10.dp)

                )

            }
        }
    }
}


fun getCardData() : List<CardItemData>{

    return listOf(
        CardItemData(R.drawable.ironman, "Iron Man"),
        CardItemData(R.drawable.captain_america, "Captain America"),
        CardItemData(R.drawable.hulk, "Hulk"),
        CardItemData(R.drawable.thor, "Thor"),
        CardItemData(R.drawable.black_widow, "Black Widow"),
        CardItemData(R.drawable.spiderman, "Spider Man"),
        CardItemData(R.drawable.black_panther, "Black Panther"),
        CardItemData(R.drawable.deadpool, "Deadpool"),

        CardItemData(R.drawable.batman, "Batman"),
        CardItemData(R.drawable.superman, "Superman"),
        CardItemData(R.drawable.aquaman, "Aquaman"),
        CardItemData(R.drawable.wonder_woman, "Wonder Woman"),
        CardItemData(R.drawable.flash, "Flash"),
        CardItemData(R.drawable.green_lantern, "Green Lantern"),

    )
}


@Composable
fun CardDesign (itemData: CardItemData){
    val context = LocalContext.current
    Card(
        onClick = {
        Toast.makeText(context, itemData.title, Toast.LENGTH_SHORT).show()
    }, modifier = Modifier
            .size(130.dp)
    ) {
        Column (
            modifier = Modifier
                .padding(5.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(itemData.image),
                contentDescription = itemData.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(80.dp)
            )

            Text(
                text = itemData.title,
                modifier = Modifier.padding(top = 2.dp),
                fontWeight = FontWeight.Bold
            )

        }
    }
}
