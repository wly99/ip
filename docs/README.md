# User Guide

## Features
1. Add a variety of tasks that can be classified as Todos, Events or Deadlines.
2. You can also marks tasks as done.
3. And also delete tasks.
4. Tasks can be saved to a txt file and it will be retrieved even after stopping the program.

### Feature 1 Adding tasks
Add Todo that only has a description.
Add Event that has description and a time.
Add Deadline that has description and a time.

### Feature 2 Viewing tasks
Duke can list all the tasks you currently have.

### Feature 3 Marking tasks as done
Duke can mark specified tasks as done.

### Feature 4 Deleting tasks
Duke can delete the specified tasks.

### Feature 5 Auto saving of tasks
Duke will save all the tasks you made into a txt file and it will not be lost even after quitting the program.

## Usage

### `todo` - adds a Todo to your list of tasks

Example of usage: 

`todo complete CS2113 tutorial`

Expected outcome:

`I added 'complete CS2113 tutorial' to the list`

### `event` - adds an Event to your list of tasks

Example of usage: 

`event CS2113 tutorial /at 4pm`

Expected outcome:

`I added 'CS2113 tutorial' to the list`

### `deadline` - adds a Deadline to your list of tasks

Example of usage: 

`deadline complete repl.it /by Sunday 4pm`

Expected outcome:

`I added 'complete repl.it' to the list"`

### `done` - marks a task as done by its number

Example of usage: 

`done 2`

Expected outcome:

`Nice! I've marked this task as done:
2.[D][✓] Submit assignment (by: 8)`

### `list` - lists your tasks

Example of usage: 

`list`

Expected outcome:

`Here's what you have in the list:
1.[T][✘] groceries
2.[D][✘] Submit assignment (by: 8)
3.[E][✓] Birthday party (at: 8pm Sat)
4.[T][✓] get milk
5.[T][✘] complete CS2113 tutorial
6.[E][✘] CS2113 tutorial (at: 4pm)
7.[D][✘] complete repl.it (by: Sunday 4pm)`

### `delete` - deletes a task by its number

Example of usage: 

`delete 3`

Expected outcome:

`Noted. I've removed this task: 
  [E][✓] Birthday party (at: 8pm Sat)
Now you have 6 tasks in the list.`

### `find` - find tasks that contains the search word or words

Example of usage: 

`find party`

Expected outcome:

`Here are the matching tasks in your list:
1.[E][✓] Birthday party (at: 8pm Sat)`
