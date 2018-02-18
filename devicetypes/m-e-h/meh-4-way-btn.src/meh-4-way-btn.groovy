/**
 *  SmartThings Device Handler: MEH 4-way btn
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
	definition (name: "MEH 4-way btn", namespace: "m-e-h", author: "Marty Helmick") {
		capability "Actuator"
		capability "Door Control"
        capability "Garage Door Control"
		capability "Contact Sensor"
		capability "Refresh"
		capability "Sensor"
        
        command "open_2"
        command "opening_1"
        command "closing_3"
		command "closed_4"
	}

	simulator {
		
	}

	tiles {
		standardTile("toggle", "device.door", inactiveLabel: true, width: 3, height: 3) {
			state("opening", label:"1", icon:"st.doors.garage.garage-opening", backgroundColor:"#07F7D7")
			state("open", label:"2", action:"door control.close", icon:"st.doors.garage.garage-open", backgroundColor:"#8CFC03")
			state("closing", label:"3", icon:"st.doors.garage.garage-closing", backgroundColor:"#5F07F7")
			state("closed", label:"4", action:"door control.open", icon:"st.doors.garage.garage-closed", backgroundColor:"#FC030F")
			
		}
		standardTile("open", "device.door", inactiveLabel: false, decoration: "flat") {
			state "default", label:"Opening 1", action:"door control.open", icon:"st.doors.garage.garage-opening"
		}
        standardTile("open_2", "device.door", inactiveLabel: false, decoration: "flat") {
			state "default", label:"Open 2", action:"open_2", icon:"st.doors.garage.garage-open"
		}
		standardTile("close", "device.door", inactiveLabel: false, decoration: "flat") {
			state "default", label:"Closing 3", action:"door control.close", icon:"st.doors.garage.garage-closing"
		}
        standardTile("closed_4", "device.door", inactiveLabel: false, decoration: "flat") {
			state "default", label:"Closed 4 ", action:"closed_4", icon:"st.doors.garage.garage-closed"
		}

		main "toggle"
		details(["toggle", "open", "open_2", "close", "closed_4"])
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

def opening_1() {
    sendEvent(name: "door", value: "opening")
}

def open_2() {
    sendEvent(name: "door", value: "open")
}

def closing_3() {
    sendEvent(name: "door", value: "closing")
}

def closed_4() {
    sendEvent(name: "door", value: "closed")
}
