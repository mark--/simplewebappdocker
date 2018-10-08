#!/bin/bash
echo "***** Starting Selenium Test"
echo "* Waiting 5 seconds for application"

sleep 5

# Starting Virtual Screen
Xvfb :1 -screen 5 1024x768x8 &
export DISPLAY=:1.5

cd /tmp/testscripts
selenium-side-runner --output-directory $(pwd) SimpleWebApp.side


# Kill virtual screen
killall -9 Xvfb
