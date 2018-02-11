metadata {
	definition (name: "4-way Btn", namespace: "smartthings", author: "m-e-h") {
		capability "Actuator"
		capability "Door Control"
    capability "Garage Door Control"
		capability "Refresh"
		capability "Sensor"
        
        command "level_one"
        command "level_two"
        command "level_three"
        command "level_four"
	}

	simulator {
		
	}

	tiles {
		standardTile("toggle", "device.door", inactiveLabel: true, width: 3, height: 3) {
			state("closed", label:"Level One", action:"door control.open", icon:"st.Food & Dining.dining1", backgroundColor:"#FC030F")
			state("open", label:"Level Two", action:"door control.close", icon:"st.Health & Wellness.health8", backgroundColor:"#8CFC03")
			state("opening", label:"Level Three", icon:"st.Office.office6", backgroundColor:"#07F7D7")
			state("closing", label:"Level Four", icon:"st.Food & Dining.dining13", backgroundColor:"#5F07F7")
			
		}
		standardTile("open", "device.door", inactiveLabel: false, decoration: "flat") {
			state "default", label:"Level Three", action:"door control.open", icon:"st.Office.office6"
		}
		standardTile("close", "device.door", inactiveLabel: false, decoration: "flat") {
			state "default", label:"Level Four", action:"door control.close", icon:"st.Food & Dining.dining13"
		}
        standardTile("level_two", "device.door", inactiveLabel: false, decoration: "flat") {
			state "default", label:"Level Two", action:"level_two", icon:"st.Health & Wellness.health8"
		}
        standardTile("level_one", "device.door", inactiveLabel: false, decoration: "flat") {
			state "default", label:"Level One", action:"level_one", icon:"st.Food & Dining.dining1"
		}

		main "toggle"
		details(["toggle", "open", "close", "level_one", "level_two"])
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

def level_one() {
    sendEvent(name: "door", value: "closed")
}

def level_two() {
    sendEvent(name: "door", value: "open")
}

def level_three() {
    sendEvent(name: "door", value: "opening")
}

def level_four() {
    sendEvent(name: "door", value: "closing")
}