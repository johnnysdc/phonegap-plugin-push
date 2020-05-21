require 'rubygems'
require 'pushmeup'
GCM.host = 'https://fcm.googleapis.com/fcm/send'
GCM.format = :json
GCM.key = "API_KEY_GOES_HERE"
destination = ["REGISTRATION_ID_GOES_HERE"]
data = {:message => "Push with Ruby works well!", :msgcnt => "1", :soundname => "beep.wav"}

GCM.send_notification( destination, data)
