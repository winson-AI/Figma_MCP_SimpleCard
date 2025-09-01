package com.example.simplecard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import simplecard.composeapp.generated.resources.Res
import simplecard.composeapp.generated.resources.bg_card_visa_improved
import simplecard.composeapp.generated.resources.bg_card_mastercard_improved
import simplecard.composeapp.generated.resources.ic_arrow_down
import simplecard.composeapp.generated.resources.ic_wifi
import simplecard.composeapp.generated.resources.ic_signal
import simplecard.composeapp.generated.resources.ic_visa
import simplecard.composeapp.generated.resources.ic_mastercard
import simplecard.composeapp.generated.resources.ic_battery

@Composable
@Preview
fun App() {
    MaterialTheme {
        AccountCardScreen()
    }
}

@Composable
fun AccountCardScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Status Bar
            StatusBar()
            
            // Navigation Bar
            NavigationBar()
            
            // Tab Buttons
            TabButtons()
            
            // Cards
            CardsSection()
            
            // Add Card Button
            AddCardButton()
            
            // Bottom Indicator
            BottomIndicator()
        }
    }
}

@Composable
fun StatusBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(32.dp)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "9:41 AM",
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF343434)
        )
        
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(Res.drawable.ic_signal),
                contentDescription = "Signal",
                modifier = Modifier
                    .width(17.dp)
                    .height(10.dp)
            )
            Image(
                painter = painterResource(Res.drawable.ic_wifi),
                contentDescription = "WiFi",
                modifier = Modifier
                    .width(12.dp)
                    .height(9.dp)
            )
            Image(
                painter = painterResource(Res.drawable.ic_battery),
                contentDescription = "Battery",
                modifier = Modifier
                    .width(24.dp)
                    .height(12.dp)
            )
        }
    }
}

@Composable
fun NavigationBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(53.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(Res.drawable.ic_arrow_down),
            contentDescription = "Back",
            modifier = Modifier
                .size(16.dp)
                .rotate(90f)
        )
        
        Text(
            text = "Account and card",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF343434) ,
            modifier = Modifier.padding(start = 12.dp)
        )
        
        Spacer(modifier = Modifier.width(16.dp))
    }
}

@Composable
fun TabButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(
            onClick = { },
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF2F1F9)
            ),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(
                text = "Account",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF343434)
            )
        }
        
        Button(
            onClick = { },
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF3629B7)
            ),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(
                text = "Card",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
        }
    }
}

@Composable
fun CardsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // First Card (Visa)
        CreditCard(
            cardBackground = Res.drawable.bg_card_visa_improved,
            cardLogo = Res.drawable.ic_visa,
            cardNumber = "4756 9018",
            cardHolder = "John Smith",
            cardType = "Amazon Platinium",
            balance = "$3.469.52",
            backgroundColor = Color.Transparent
        )
        
        // Second Card (Mastercard)
        CreditCard(
            cardBackground = Res.drawable.bg_card_mastercard_improved,
            cardLogo = Res.drawable.ic_mastercard,
            cardNumber = "4756 9018",
            cardHolder = "John Smith",
            cardType = "Amazon Platinium",
            balance = "$3.469.52",
            backgroundColor = Color.Transparent
        )
    }
}

@Composable
fun CreditCard(
    cardBackground: org.jetbrains.compose.resources.DrawableResource?,
    cardLogo: org.jetbrains.compose.resources.DrawableResource?,
    cardNumber: String,
    cardHolder: String,
    cardType: String,
    balance: String,
    backgroundColor: Color = Color.Transparent
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(204.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundColor)
    ) {
        // Card Background
        cardBackground?.let { background ->
            Image(
                painter = painterResource(background),
                contentDescription = "Card Background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }
        
        // Card Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Top section
            Column {
                Text(
                    text = cardHolder,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                )
                
                Spacer(modifier = Modifier.height(42.dp))
                
                Text(
                    text = cardType,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }
            
            // Bottom section
            Column {
                // Card number with middle hidden circles
                val parts = remember(cardNumber) { cardNumber.trim().split(" ") }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = parts.firstOrNull() ?: cardNumber,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.White
                        )
                        // Circles for hidden middle digits
                        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                            repeat(4) {
                                Box(
                                    modifier = Modifier
                                        .size(6.dp)
                                        .clip(RoundedCornerShape(3.dp))
                                        .background(Color.White.copy(alpha = 0.4f))
                                )
                            }
                        }

                        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                            repeat(4) {
                                Box(
                                    modifier = Modifier
                                        .size(6.dp)
                                        .clip(RoundedCornerShape(3.dp))
                                        .background(Color.White.copy(alpha = 0.4f))
                                )
                            }
                        }

                        Text(
                            text = parts.lastOrNull() ?: "",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.White
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = balance,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
        
        // Card Logo (bottom right)
        cardLogo?.let { logo ->
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(20.dp)
            ) {
                Image(
                    painter = painterResource(logo),
                    contentDescription = "Card Logo",
                    modifier = Modifier.size(48.dp)
                )
            }
        }
    }
}

@Composable
fun AddCardButton() {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF3629B7)
        ),
        shape = RoundedCornerShape(15.dp)
    ) {
        Text(
            text = "Add card",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
    }
}

@Composable
fun BottomIndicator() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(134.dp)
                .height(5.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(Color(0xFFCACACA))
        )
    }
}