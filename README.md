Pre-work - My Items

My Items is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: Hina Khan

Time spent: 25 hours spent in total

User Stories

The following functionality is completed:

[Y] User can successfully add and remove items from the todo list 
[Y] User can tap a todo item in the list and bring up an edit screen for the todo item and then have any changes to the text 
reflected in the todo list. 
[Y] User can persist todo items and retrieve them properly on app restart

# The following additional features are implemented:

* Persist the todo items into SQLite
* Improve style of the todo items in the list used a custom adapter using Recycler view
* Use a DialogFragment instead of new Activity for editing items
* Add support for selecting the priority of each todo item
* Tweak the style improving the UI / UX, play with colors, images or backgrounds, use different colors and images across the layput
* Use splash screen
* User can add any number of items and user can scroll it.Also user can delete any time in the list

## Video Walkthrough 

Here's a walkthrough of implemented user stories:

<img src='My_Item.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

**Question 1:** "What are your reactions to the Android app development platform so far? Compare and contrast Android's approach to layouts and user interfaces in past platforms you've used."

As we all know Android app development platform is growing everyday. If I compare with platforms in the past there are plenty of changes happened till now.
First of all, android applications are very user friendly and is easy to use, is just because of the enhancement and new versions. Android provide lots of UI components for android developers to design graphic user interface (UI) in android application. Layout and UI is not much difficult in android because it provides lots of components to build good application.
Like now favorite is the app search bar. Where you just type words into, and Android searches your app collection for any apps with that name, Fingerprint, Google pay these are my favorite items.
Like now we have Recycler and Card view which is very useful as compare with table layout and others in android. For Input controls apart from Image, Radio, Toggle button now we have  Rating bar, Spinner, Date and Time picker which won’t take much time for implementation and is very user friendly.
Also there are Toast, Dialog, advance navigation, action bar and menu, which make the app user friendly and interactive.
We also have many useful support libraries, which make developers work easy to implement.

**Question 2:**"Take a moment to reflect on the `ArrayAdapter` used in your pre-work. How would you describe an adapter in this context and what is its function in Android? Why do you think the adapter is important? Explain the purpose of the `convertView` in the `getView` method of the `ArrayAdapter`."

Adapter in android is helpful to create a layer between UI components and the data source that fill data into the UI components 
For instance: If I want to display the list of items in my application and If I use List View. This List view doesn’t contain any data, in reality is just a UI element without any data, which we initialize first in xml file. With the help of Adapter, you can display the list of items. List View contain it’s own adapter which help to display the data.
Adapter includes various methods to communicate data to the List View.
Adapter can be customize also means you can create your adapter by implementing Base Adapter. In short, An adapter is an object that provides views for a list view. It help to populate the data and display on. the UI. You can use custom adapters or you can use it’s own methods.
Lastly, convert View is used to reuse old view.

Describe any challenges encountered while building the app.
I dont' believe so I had the problems which took a very long time for me to resolve it but it seems very interesting to me.
Looking forward to get response from you.


GIF created with [LiceCap](http://www.cockos.com/licecap/).

## License

    Copyright [yyyy] [name of copyright owner]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

