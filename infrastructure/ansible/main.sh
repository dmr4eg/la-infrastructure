#!/bin/env python3
#!/bin/env false

# Init the venv
python3 -m venv .venv
source .venv/bin/activate

# Install ansible
pip3 install ansible kubernetes pyyaml
ansible-galaxy collection install kubernetes.core

ansible-playbook main.yaml \
  -e @group_vars/vault_github_token.yml \
  --ask-vault-pass --ask-become-pass

#ansible-playbook main.yaml \
#  -e @group_vars/vault_github_token.yml \
#  --ask-vault-pass --ask-become-pass \
#  --skip-tags "kind-cluster-creation"

