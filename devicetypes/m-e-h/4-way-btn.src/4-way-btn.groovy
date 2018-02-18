/**
 *  SmartThings Device Handler: Virtual 4-way button
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 *  Author: Marty Helmick
 *  Date: 2018-02-04
 *
 */


metadata {
	definition (name: "Four Way Button", namespace: "smartthings", author: "Marty Helmick") {
		capability "Actuator"
		capability "Door Control"
    capability "Garage Door Control"
		capability "Refresh"
		capability "Sensor"
        
        command "closed_4"
        command "open_2"
        command "opening_1"
        command "closing_3"
	}

	simulator {
		
	}

	tiles {
		standardTile("toggle", "device.door", inactiveLabel: true, width: 3, height: 3) {
			state("closed", label:"Hungry", action:"door control.open", icon:"st.Food & Dining.dining1", backgroundColor:"#FC030F")
			state("open", label:"Not Hungry", action:"door control.close", icon:"st.Health & Wellness.health8", backgroundColor:"#8CFC03")
			state("opening", label:"Breakfast", icon:"st.Office.office6", backgroundColor:"#07F7D7")
			state("closing", label:"Dinner", icon:"st.Food & Dining.dining13", backgroundColor:"#5F07F7")
			
		}
		standardTile("open", "device.door", inactiveLabel: false, decoration: "flat") {
			state "default", label:"Opening 1", action:"door control.open", icon:"st.Office.office6"
		}
		standardTile("close", "device.door", inactiveLabel: false, decoration: "flat") {
			state "default", label:"Closing 3", action:"door control.close", icon:"st.Food & Dining.dining13"
		}
        standardTile("open_2", "device.door", inactiveLabel: false, decoration: "flat") {
			state "default", label:"Open 2", action:"open_2", icon:"st.Health & Wellness.health8"
		}
        standardTile("closed_4", "device.door", inactiveLabel: false, decoration: "flat") {
			state "default", label:"Closed 4 ", action:"closed_4", icon:"st.Food & Dining.dining1"
		}

		main "toggle"
		details(["toggle", "open", "close", "closed_4", "open_2"])
	}
}

def parse(String description) {
	log.trace "parse($description)"
}

def open() {
	sendEvent(name: "door", value: "opening")
}

def close() {
    sendEvent(name: "door", value: "closing")
}

def closed_4() {
    sendEvent(name: "door", value: "closed")
}

def open_2() {
    sendEvent(name: "door", value: "open")
}

def opening_1() {
    sendEvent(name: "door", value: "opening")
}

def closing_3() {
    sendEvent(name: "door", value: "closing")
}
