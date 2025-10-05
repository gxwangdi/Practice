#!/bin/bash/ -xv

echo "1. Display the path to your home dir:"
echo $HOME
echo "the terminal type that you are using:"
echo $TERM
echo "All services started up in runlevel 3 on your system"
ls /etc/rc3.d/S*

echo "2. Add comments in your script."
set -x
# This is a comment, not executed so would not show in -x mode.
set +x


