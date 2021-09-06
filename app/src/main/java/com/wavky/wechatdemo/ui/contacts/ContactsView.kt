package com.wavky.wechatdemo.ui.contacts

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wavky.wechatdemo.data.Contact
import com.wavky.wechatdemo.data.getDefaultContactList
import com.wavky.wechatdemo.ui.Tabs
import com.wavky.wechatdemo.ui.common.TopBar
import com.wavky.wechatdemo.ui.common.extension.toStringRes

/**
 * Created on 2021/08/30
 * @author Wavky.Huang
 */
@Composable
fun ContactsView(modifier: Modifier = Modifier) {
  Scaffold(
    modifier,
    topBar = { TopBar(Tabs.CONTACTS.textId) }
  ) {
    val contactGroups = getDefaultContactList().group().sortedList()
    LazyColumn {
      for (group in contactGroups) {
        contactGroupItem(group)
      }
    }
  }
}

private fun LazyListScope.contactGroupItem(contactGroup: ContactGroup) {
  item { ContactGroupHeaderView(groupName = contactGroup.groupKey.toString()) }
  items(contactGroup.groupValue) { contact ->
    ContactItemView(contact)
  }
}

/**
 * Random contact array to random dictionary.
 *
 * `[Contact] -> [Character : [Contact]]`
 *
 * Example:
 * ```
 * [Contact(China), Contact(Japan), Contact(America), Contact(Chile)]
 * ↓
 * ["C": [Contact(Chile), Contact(China)],
 *  "J": [Contact(Japan)],
 *  "A": [Contact(America)]]
 *  ```
 */
@Composable
private fun List<Contact>.group(): Map<Char, List<Contact>> {
  val sorted = this.sortedBy { it.nameId.toStringRes() }
  val groupedMap: MutableMap<Char, MutableList<Contact>> = mutableMapOf()
  for (contact in sorted) {
    val key = contact.nameId.toStringRes().firstOrNull() ?: continue
    val group = groupedMap[key] ?: mutableListOf()
    group.add(contact)
    groupedMap[key] = group
  }
  return groupedMap
}

/**
 * Random dictionary to sorted array of contact's group.
 *
 * `[Character : [Contact]] -> [ContactGroup]`
 *
 * Example:
 *  ```
 *  ["C": [Contact(Chile), Contact(China)],
 *   "J": [Contact(Japan)],
 *   "A": [Contact(America)]]
 *                 ↓
 *  [ContactGroup("A", [Contact(America)]),
 *   ContactGroup("C", [Contact(Chile), Contact(China)]),
 *   ContactGroup("J", [Contact(Japan)])]
 *  ```
 */
private fun Map<Char, List<Contact>>.sortedList(): List<ContactGroup> {
  val sortedList: MutableList<ContactGroup> = mutableListOf()
  val sortedKeys = keys.sorted()
  for (key in sortedKeys) {
    this[key]?.let { contacts ->
      sortedList.add(
        ContactGroup(groupKey = key, groupValue = contacts)
      )
    }
  }
  return sortedList
}

private data class ContactGroup(
  val groupKey: Char,
  val groupValue: List<Contact>
)

@Preview
@Composable
fun ContactsViewPreview() {
  ContactsView(Modifier.fillMaxSize())
}
