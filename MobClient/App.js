import * as React from "react";
import MapView from "react-native-maps";
import {
  StyleSheet,
  Text,
  View,
  Dimensions,
  Image,
  Button,
} from "react-native";
import { useEffect, useState } from "react";
import axios from "axios";
import { render } from "react-dom";

let url = "http://localhost:8080/ScooterRestfulService/api/scooters";

export default function App() {
  const [scooters, setScooters] = useState([]);
  // create a state variable to hold the scooters
  const fetchApi = async () => {
    try {
      const response = await axios.get(url);
      // console.log(response.data);
      setScooters(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  const ClaimScooter = async () => {
    try {
      const response = await axios.patch(url + "/book/" + scooter.id + "/true");
      console.log(response.data);
      setScooters(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    fetchApi();
  }, []);

  return (
    <View style={styles.container}>
      <MapView
        provider={MapView.PROVIDER_GOOGLE}
        region={{
          latitude: -36.8484,
          longitude: 174.7622,
          latitudeDelta: 0.0922,
          longitudeDelta: 0.0421,
        }}
        style={styles.map}
      >
        {scooters.map(
          (scooter) => (
            scooter.isAvailable
              ? console.log(scooter.isAvailable)
              : console.log(scooter.isAvailable),
            (
              <MapView.Marker
                coordinate={{
                  latitude: scooter.lat,
                  longitude: scooter.long,
                }}
                title={"Scooter ID: " + scooter.id}
              >
                <MapView.Callout>
                  <View style={styles.callout}>
                    <Text style={styles.text}>Scooter ID: {scooter.id}</Text>
                    <Text style={styles.text}>
                      {scooter.isAvailable ? "Available" : "Unavailable"}
                    </Text>
                    {scooter.isAvailable && (
                      <Button title="Claim" onPress={ClaimScooter} />
                    )}
                  </View>
                </MapView.Callout>
                <Image source={require("./scooter.png")} style={styles.Image} />
              </MapView.Marker>
            )
          )
        )}
      </MapView>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
  },
  map: {
    width: Dimensions.get("window").width,
    height: Dimensions.get("window").height,
  },
  Image: {
    width: 40,
    height: 40,
  },
  callout: {
    width: 200,
    height: 100,
    backgroundColor: "#fff",
    borderRadius: 10,
    alignItems: "center",
    justifyContent: "center",
  },
});
